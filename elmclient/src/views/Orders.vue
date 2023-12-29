<template>
    <div class="wrapper">
        <!-- header部分 -->
        <header>
            <p>确认订单</p>
        </header>

        <!-- 订单信息部分 -->
        <div class="order-info">
            <h5>订单配送至：</h5>
            <div class="order-info-address" @click="toUserAddress">
                <p>
                    {{
                        deliveryaddress != null
                            ? deliveryaddress.address
                            : "请选择收货地址"
                    }}
                </p>
                <i class="fa fa-angle-right"></i>
            </div>
            <p>
                {{ user.userName }}{{ sexFilter(user.userSex) }}
                {{ user.userId }}
            </p>
        </div>

        <h3>{{ business.businessName }}</h3>

        <!-- 订单明细部分 -->
        <ul class="order-detailed">
            <li v-for="item in cartArr">
                <div class="order-detailed-left">
                    <img :src="item.food.foodImg" />
                    <p>{{ item.food.foodName }} x {{ item.quantity }}</p>
                </div>
                <p>
                    &#165;{{ (item.food.foodPrice * item.quantity).toFixed(2) }}
                </p>
            </li>
        </ul>
        <div class="order-deliveryfee">
            <p>配送费</p>
            <p>&#165;{{ business.deliveryPrice }}</p>
        </div>
        <div class="order-deliverytime">
            <div v-if="pythonResult !== null">
                <p class="time">预计送餐时间：{{ pythonResult }} 分钟</p>
                <p class="distance">
                    骑手距离：{{ this.distance.toFixed(2) }} km
                </p>
                <p class="rating">骑手评分：{{ this.deliveryperson.rating }}</p>
                <div class="peak">
                    <p v-if="this.isPeak() == 1">当前处于送餐高峰期</p>
                    <p v-else>当前不处于送餐高峰期</p>
                </div>
            </div>
            <p v-else>送餐时间计算中...请稍等</p>
        </div>

        <!-- 订单合计部分 -->
        <div class="total">
            <div class="total-left">&#165;{{ totalPrice }}</div>
            <div class="total-right" @click="toPayment">去支付</div>
        </div>
    </div>
</template>

<script>
export default {
    name: "Orders",
    data() {
        return {
            businessId: this.$route.query.businessId,
            business: {},
            user: {},
            cartArr: [],
            deliveryaddress: {},
            deliveryperson: {},
            pythonResult: null,
            distance: 0,
            token: "",
            config: {},
        };
    },
    created() {
        this.user = this.$getSessionStorage("user");
        this.token = this.$getSessionStorage("token");
        this.deliveryaddress = this.$getLocalStorage(this.user.userId);
        this.config = { headers: { token: this.token } };

        //查询当前商家
        this.$axios
            .get(`businesses/${this.businessId}`, this.config)
            .then((response) => {
                this.business = response.data;
            })
            .catch((error) => {
                console.error(error);
            });
        //查询当前用户在购物车中的当前商家食品列表
        var data = {
            userId: this.user.userId,
            businessId: this.businessId,
        };
        this.$axios
            .post(`carts/list`, data, this.config)
            .then((response) => {
                this.cartArr = response.data;
            })
            .catch((error) => {
                console.error(error);
            });

        this.getDeliveryPersonById();
    },
    computed: {
        totalPrice() {
            let totalPrice = 0;
            for (let cartItem of this.cartArr) {
                totalPrice += cartItem.food.foodPrice * cartItem.quantity;
            }
            totalPrice += this.business.deliveryPrice;
            return totalPrice.toFixed(2);
        },
    },
    methods: {
        sexFilter(value) {
            return value == 1 ? "先生" : "女士";
        },
        toUserAddress() {
            this.$router.push({
                path: "/userAddress",
                query: { businessId: this.businessId },
            });
        },
        toPayment() {
            if (this.deliveryaddress == null) {
                alert("请选择送货地址!");
                return;
            }

            //创建订单
            var data = {
                userId: this.user.userId,
                businessId: this.businessId,
                daId: this.deliveryaddress.daId,
                orderTotal: this.totalPrice,
            };
            this.$axios
                .post(`orders/create`, data, this.config)
                .then((response) => {
                    let orderId = response.data;
                    if (orderId > 0) {
                        this.$router.push({
                            path: "/payment",
                            query: { orderId: orderId },
                        });
                    } else {
                        alert("创建订单失败!");
                    }
                })
                .catch((error) => {
                    console.error(error);
                });
        },

        getDeliveryPersonById() {
            let personId = Math.round(Math.random() * (1 - 23) + 23);

            this.$axios
                .get(`deliveryPerson/${personId}`, this.config)
                .then((response) => {
                    this.deliveryperson = response.data;
                    this.distance = Math.random() * (1 - 5) + 5;
                    var params = {
                        age: this.deliveryperson.age,
                        rating: this.deliveryperson.rating,
                        distance: this.distance,
                        isPeak: this.isPeak(),
                    };
                    this.$axios
                        .get("PythonController/deliveryTime", { params: params, ...this.config })
                        .then((response) => {
                            this.pythonResult = parseInt(response.data).toFixed(0);
                        })
                        .catch((error) => {
                            console.error(error);
                        });
                })
                .catch((error) => {
                    console.error(error);
                });
        },

        isPeak() {
            const currentHour = new Date().getHours();
            if (
                (currentHour >= 7 && currentHour < 9) ||
                (currentHour >= 11 && currentHour < 13) ||
                (currentHour >= 17 && currentHour < 19)
            ) {
                return 1;
            } else {
                return 0;
            }
        },
    },
};
</script>

<style scoped>
/********** 总容器 **********/
.wrapper {
    width: 100%;
    height: 100%;
}

/********** header **********/
.wrapper header {
    width: 100%;
    height: 12vw;
    background-color: #0097ff;
    color: #fff;
    font-size: 4.8vw;
    position: fixed;
    left: 0;
    top: 0;
    z-index: 1000;

    display: flex;
    justify-content: center;
    align-items: center;
}

/********** 订单信息部分 **********/
.wrapper .order-info {
    width: 100%;
    margin-top: 12vw;
    background-color: #0097ef;
    box-sizing: border-box;
    padding: 2vw;
    color: #fff;
}

.wrapper .order-info h5 {
    font-size: 3vw;
    font-weight: 300;
}

.wrapper .order-info .order-info-address {
    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;

    font-weight: 700;
    user-select: none;
    cursor: pointer;
    margin: 1vw 0;
}

.wrapper .order-info .order-info-address p {
    width: 90%;
    font-size: 5vw;
}

.wrapper .order-info .order-info-address i {
    font-size: 6vw;
}

.wrapper .order-info p {
    font-size: 3vw;
}

.wrapper h3 {
    box-sizing: border-box;
    padding: 3vw;
    font-size: 4vw;
    color: #666;
    border-bottom: solid 1px #ddd;
}

/********** 订单明细部分 **********/
.wrapper .order-detailed {
    width: 100%;
}

.wrapper .order-detailed li {
    width: 100%;
    height: 16vw;
    box-sizing: border-box;
    padding: 3vw;
    color: #666;

    display: flex;
    justify-content: space-between;
    align-items: center;
}

.wrapper .order-detailed li .order-detailed-left {
    display: flex;
    align-items: center;
}

.wrapper .order-detailed li .order-detailed-left img {
    width: 10vw;
    height: 10vw;
}

.wrapper .order-detailed li .order-detailed-left p {
    font-size: 3.5vw;
    margin-left: 3vw;
}

.wrapper .order-detailed li p {
    font-size: 3.5vw;
}

.wrapper .order-deliveryfee {
    width: 100%;
    height: 16vw;
    box-sizing: border-box;
    padding: 3vw;
    color: #666;
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-size: 3.5vw;
}

.wrapper .order-deliverytime {
    width: 100%;
    box-sizing: border-box;
    padding: 3vw;
    color: #666;
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-size: 4.5vw;
}
.wrapper .order-deliverytime .time {
    margin-bottom: 1vw;
}
.wrapper .order-deliverytime .distance {
    margin-bottom: 1vw;
}
.wrapper .order-deliverytime .rating {
    margin-bottom: 1vw;
}

/********** 订单合计部分 **********/
.wrapper .total {
    width: 100%;
    height: 14vw;

    position: fixed;
    left: 0;
    bottom: 0;

    display: flex;
}

.wrapper .total .total-left {
    flex: 2;
    background-color: #505051;
    color: #fff;
    font-size: 4.5vw;
    font-weight: 700;
    user-select: none;

    display: flex;
    justify-content: center;
    align-items: center;
}

.wrapper .total .total-right {
    flex: 1;
    background-color: #38ca73;
    color: #fff;
    font-size: 4.5vw;
    font-weight: 700;
    user-select: none;
    cursor: pointer;

    display: flex;
    justify-content: center;
    align-items: center;
}
</style>
