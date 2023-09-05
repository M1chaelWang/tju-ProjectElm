<template>
    <div class="wrapper">
        <!-- header -->
        <header>
            <p>兑换列表</p>
        </header>

        <!-- 兑换列表 -->
        <ul class="exchange">
            <li>
                <div class="left">
                    <div class="exchange-img">
                        <img src="../assets/exchangeList/1.jpg" />
                    </div>
                    <div class="exchange-info">
                        <h3>可湿水面纸</h3>
                        <p>湿水不易烂，可作洗脸巾</p>
                        <p>5000 吃货豆</p>
                    </div>
                </div>
                <div class="right">
                    <div>
                        <i
                            class="fa fa-minus-circle"
                            @click="minus(1)"
                            v-show="this.quantity1 != 0"
                        ></i>
                    </div>
                    <p>
                        <span v-show="this.quantity1 != 0">{{
                            this.quantity1
                        }}</span>
                    </p>
                    <div>
                        <i class="fa fa-plus-circle" @click="add(1)"></i>
                    </div>
                </div>
            </li>
            <li>
                <div class="left">
                    <div class="exchange-img">
                        <img src="../assets/exchangeList/2.jpg" />
                    </div>
                    <div class="exchange-info">
                        <h3>儿童牙膏</h3>
                        <p>不含糖分，添加维生素</p>
                        <p>2000 吃货豆</p>
                    </div>
                </div>
                <div class="right">
                    <div>
                        <i
                            class="fa fa-minus-circle"
                            @click="minus(2)"
                            v-show="this.quantity2 != 0"
                        ></i>
                    </div>
                    <p>
                        <span v-show="this.quantity2 != 0">{{
                            this.quantity2
                        }}</span>
                    </p>
                    <div>
                        <i class="fa fa-plus-circle" @click="add(2)"></i>
                    </div>
                </div>
            </li>
            <li>
                <div class="left">
                    <div class="exchange-img">
                        <img src="../assets/exchangeList/3.jpg" />
                    </div>
                    <div class="exchange-info">
                        <h3>维达卷纸</h3>
                        <p>蓝色经典，4层27卷</p>
                        <p>6000 吃货豆</p>
                    </div>
                </div>
                <div class="right">
                    <div>
                        <i
                            class="fa fa-minus-circle"
                            @click="minus(3)"
                            v-show="this.quantity3 != 0"
                        ></i>
                    </div>
                    <p>
                        <span v-show="this.quantity3 != 0">{{
                            this.quantity3
                        }}</span>
                    </p>
                    <div>
                        <i class="fa fa-plus-circle" @click="add(3)"></i>
                    </div>
                </div>
            </li>
            <li>
                <div class="left">
                    <div class="exchange-img">
                        <img src="../assets/exchangeList/4.jpg" />
                    </div>
                    <div class="exchange-info">
                        <h3>蒙牛纯牛奶</h3>
                        <p>好牛奶，自然纯</p>
                        <p>10000 吃货豆</p>
                    </div>
                </div>
                <div class="right">
                    <div>
                        <i
                            class="fa fa-minus-circle"
                            @click="minus(4)"
                            v-show="this.quantity4 != 0"
                        ></i>
                    </div>
                    <p>
                        <span v-show="this.quantity4 != 0">{{
                            this.quantity4
                        }}</span>
                    </p>
                    <div>
                        <i class="fa fa-plus-circle" @click="add(4)"></i>
                    </div>
                </div>
            </li>
            <li>
                <div class="left">
                    <div class="exchange-img">
                        <img src="../assets/exchangeList/5.jpg" />
                    </div>
                    <div class="exchange-info">
                        <h3>美汁源果粒橙</h3>
                        <p>真实果粒好活力</p>
                        <p>1000 吃货豆</p>
                    </div>
                </div>
                <div class="right">
                    <div>
                        <i
                            class="fa fa-minus-circle"
                            @click="minus(5)"
                            v-show="this.quantity5 != 0"
                        ></i>
                    </div>
                    <p>
                        <span v-show="this.quantity5 != 0">{{
                            this.quantity5
                        }}</span>
                    </p>
                    <div>
                        <i class="fa fa-plus-circle" @click="add(5)"></i>
                    </div>
                </div>
            </li>
            <li>
                <div class="left">
                    <div class="exchange-img">
                        <img src="../assets/exchangeList/6.jpg" />
                    </div>
                    <div class="exchange-info">
                        <h3>百岁山天然矿泉水</h3>
                        <p>水中贵族，百岁山</p>
                        <p>6000 吃货豆</p>
                    </div>
                </div>
                <div class="right">
                    <div>
                        <i
                            class="fa fa-minus-circle"
                            @click="minus(6)"
                            v-show="this.quantity6 != 0"
                        ></i>
                    </div>
                    <p>
                        <span v-show="this.quantity6 != 0">{{
                            this.quantity6
                        }}</span>
                    </p>
                    <div>
                        <i class="fa fa-plus-circle" @click="add(6)"></i>
                    </div>
                </div>
            </li>
            <li>
                <div class="left">
                    <div class="exchange-img">
                        <img src="../assets/exchangeList/7.jpg" />
                    </div>
                    <div class="exchange-info">
                        <h3>红牛功能饮料</h3>
                        <p>中国红牛，中国牛</p>
                        <p>6000 吃货豆</p>
                    </div>
                </div>
                <div class="right">
                    <div>
                        <i
                            class="fa fa-minus-circle"
                            @click="minus(7)"
                            v-show="this.quantity7 != 0"
                        ></i>
                    </div>
                    <p>
                        <span v-show="this.quantity7 != 0">{{
                            this.quantity7
                        }}</span>
                    </p>
                    <div>
                        <i class="fa fa-plus-circle" @click="add(7)"></i>
                    </div>
                </div>
            </li>
            <li>
                <div class="left">
                    <div class="exchange-img">
                        <img src="../assets/exchangeList/8.jpg" />
                    </div>
                    <div class="exchange-info">
                        <h3>进口品客薯片</h3>
                        <p>马来西亚进口</p>
                        <p>3000 吃货豆</p>
                    </div>
                </div>
                <div class="right">
                    <div>
                        <i
                            class="fa fa-minus-circle"
                            @click="minus(8)"
                            v-show="this.quantity8 != 0"
                        ></i>
                    </div>
                    <p>
                        <span v-show="this.quantity8 != 0">{{
                            this.quantity8
                        }}</span>
                    </p>
                    <div>
                        <i class="fa fa-plus-circle" @click="add(8)"></i>
                    </div>
                </div>
            </li>
        </ul>

        <!-- 购物车 -->
        <div class="cart">
            <div class="cart-left">
                <div
                    class="cart-left-icon"
                    :style="
                        totalQuantity == 0
                            ? 'background-color:#505051;'
                            : 'background-color:#3190E8;'
                    "
                >
                    <i class="fa fa-shopping-cart"></i>
                    <div
                        class="cart-left-icon-quantity"
                        v-show="totalQuantity != 0"
                    >
                        {{ totalQuantity }}
                    </div>
                </div>
                <div class="cart-left-info">
                    <p>{{ totalPrice }}</p>
                    <p>吃货豆</p>
                </div>
                <div class="cart-right">
                    <div class="cart-right-item" @click="exchange()">
                        去兑换
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "Exchange",
    data() {
        return {
            totalQuantity: 0,
            totalPoints: 0,
            quantity1: 0,
            quantity2: 0,
            quantity3: 0,
            quantity4: 0,
            quantity5: 0,
            quantity6: 0,
            quantity7: 0,
            quantity8: 0,
            pointsArr: [],
        };
    },
    created() {
        this.user = this.$getSessionStorage("user");
        this.loadTotalPoints();
        this.$axios
            .post(
                "PointsController/listPointsByOrderUserId",
                this.$qs.stringify({
                    userId: this.user.userId,
                })
            )
            .then((response) => {
                this.pointsArr = response.data;
            })
            .catch((error) => {
                console.error(error);
            });
    },
    computed: {
        totalQuantity() {
            let quantity =
                this.quantity1 +
                this.quantity2 +
                this.quantity3 +
                this.quantity4 +
                this.quantity5 +
                this.quantity6 +
                this.quantity7 +
                this.quantity8;
            return quantity;
        },
        totalPrice() {
            let price =
                this.quantity1 * 5000 +
                this.quantity2 * 2000 +
                this.quantity3 * 6000 +
                this.quantity4 * 10000 +
                this.quantity5 * 1000 +
                this.quantity6 * 6000 +
                this.quantity7 * 6000 +
                this.quantity8 * 3000;
            return price;
        },
    },
    methods: {
        add(index) {
            switch (index) {
                case 1:
                    this.quantity1++;
                    break;
                case 2:
                    this.quantity2++;
                    break;
                case 3:
                    this.quantity3++;
                    break;
                case 4:
                    this.quantity4++;
                    break;
                case 5:
                    this.quantity5++;
                    break;
                case 6:
                    this.quantity6++;
                    break;
                case 7:
                    this.quantity7++;
                    break;
                case 8:
                    this.quantity8++;
                    break;
            }
        },
        minus(index) {
            switch (index) {
                case 1:
                    this.quantity1--;
                    break;
                case 2:
                    this.quantity2--;
                    break;
                case 3:
                    this.quantity3--;
                    break;
                case 4:
                    this.quantity4--;
                    break;
                case 5:
                    this.quantity5--;
                    break;
                case 6:
                    this.quantity6--;
                    break;
                case 7:
                    this.quantity7--;
                    break;
                case 8:
                    this.quantity8--;
                    break;
            }
        },
        exchange() {
            if (this.totalPoints >= this.totalPrice) {
                this.$axios
                    .post(
                        "UserController/subTotalPoints",
                        this.$qs.stringify({
                            userId: this.user.userId,
                            totalPoints: this.totalPrice,
                        })
                    )
                    .then(
                        this.$router.push({
                            path: "/Index",
                        })
                    )
                    .catch((error) => {
                        console.error(error);
                    });

                let tempTotalPrice = this.totalPrice;
                for (let i = 0; i < this.pointsArr.length; i++) {
                    tempTotalPrice -= this.pointsArr[i].point;
                    if (tempTotalPrice >= 0) {
                        this.$axios
                            .post(
                                "PointsController/removePoints",
                                this.$qs.stringify({
                                    pointId: this.pointsArr[i].pointId,
                                })
                            )
                            .catch((error) => {
                                console.error(error);
                            });
                        if (tempTotalPrice == 0) break;
                    } else {
                        let res = -tempTotalPrice;
                        this.$axios
                            .post(
                                "PointsController/updatePoints",
                                this.$qs.stringify({
                                    pointId: this.pointsArr[i].pointId,
                                    point: res,
                                })
                            )
                            .catch((error) => {
                                console.error(error);
                            });
                    }
                }
            } else {
                alert("您的积分不足！");
            }
        },
        loadTotalPoints() {
            this.$axios
                .post(
                    "UserController/getTotalPoints",
                    this.$qs.stringify({
                        userId: this.user.userId,
                    })
                )
                .then((response) => {
                    this.totalPoints = response.data;
                })
                .catch((error) => {
                    console.error(error);
                });
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

/**********兑换列表************/
.wrapper .exchange {
    width: 100%;
    margin-top: 12vw;
    padding-bottom: 14vw;
}
.wrapper .exchange li {
    width: 100%;
    box-sizing: border-box;
    padding: 2.5vw;
    border-bottom: solid 1px #ddd;
    user-select: none;
    cursor: pointer;
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.wrapper .exchange li .left {
    display: flex;
    align-items: center;
}
.wrapper .exchange li .left .exchange-img {
    position: relative;
}
.wrapper .exchange li .left .exchange-img img {
    width: 20vw;
    height: 20vw;
}
.wrapper .exchange li .left .exchange-info {
    margin-left: 3vw;
}
.wrapper .exchange li .left .exchange-info h3 {
    font-size: 3.8vw;
    color: #555;
}
.wrapper .exchange li .left .exchange-info p {
    font-size: 2vw;
    color: #888;
    margin-top: 2vw;
}

.wrapper .exchange li .right {
    width: 16vw;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.wrapper .exchange li .right .fa-minus-circle {
    font-size: 5.5vw;
    color: #999;
    cursor: pointer;
}

.wrapper .exchange li .right p {
    font-size: 3.6vw;
    color: #333;
}

.wrapper .exchange li .right .fa-plus-circle {
    font-size: 5.5vw;
    color: #0097ef;
    cursor: pointer;
}
/*********购物车********/
.wrapper .cart {
    width: 100%;
    height: 14vw;
    position: fixed;
    left: 0;
    bottom: 0;
    display: flex;
}

.wrapper .cart .cart-left {
    flex: 2;
    background-color: #505051;
    display: flex;
}

.wrapper .cart .cart-left .cart-left-icon {
    width: 16vw;
    height: 16vw;
    box-sizing: border-box;
    border: solid 1.6vw #444;
    border-radius: 8vw;
    background-color: #3190e8;
    font-size: 7vw;
    color: #fff;
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: -4vw;
    margin-left: 3vw;
    position: relative;
}

.wrapper .cart .cart-left .cart-left-icon-quantity {
    width: 5vw;
    height: 5vw;
    border-radius: 2.5vw;
    background-color: red;
    color: #fff;
    font-size: 3.6vw;
    display: flex;
    justify-content: center;
    align-items: center;
    position: absolute;
    right: -1.5vw;
    top: -1.5vw;
}

.wrapper .cart .cart-left .cart-left-info p:first-child {
    font-size: 4.5vw;
    color: #fff;
    margin-top: 1vw;
}

.wrapper .cart .cart-left .cart-left-info p:last-child {
    font-size: 2.8vw;
    color: #aaa;
}

.wrapper .cart .cart-right {
    flex: 1;
}

/***达到配送费***/
.wrapper .cart .cart-right .cart-right-item {
    width: 50%;
    height: 100%;
    background-color: #38ca73;
    color: #fff;
    font-size: 4.5vw;
    font-weight: 700;
    user-select: none;
    cursor: pointer;
    margin-left: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>
