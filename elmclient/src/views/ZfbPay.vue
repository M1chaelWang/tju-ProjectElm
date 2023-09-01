<template>
  <div class="wrapper">
    <img src="../assets/zfb_pay.jpg" />
    <Footer></Footer>
  </div>
</template>

<script>
import Footer from "../components/Footer.vue";
export default {
  name: "ZfbPay",
  components: {
    Footer,
  },
};
</script>

<style scoped>
.wrapper {
  width: 100%;
  height: 80%;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
</style>
