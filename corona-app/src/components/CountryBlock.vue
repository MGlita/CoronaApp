<template>
    <div class="block">
        <span class="flag"><img :src="getImgUrl(flag)"></span>

        <span class="country">{{country}}</span>
        <span>Liczba zakażonych: {{count}}</span>
    </div>    
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class CountryBlock extends Vue {
  @Prop() private country!: string;
  @Prop() private flag!: string;
  @Prop() private count!: number;   
  getImgUrl(pic:string) {
    return require('../assets/'+pic)
}
}

</script>

<style scoped>
.block{
    flex: 0 0 26%;
    margin-bottom: 70px;
    width: 300px;
    height: 70px;
    border-radius: 10px;
    background: #f2f2f2;
    box-shadow: 0 5px 10px 0 rgba(0, 0,0,.3);
    cursor: pointer;
    display:flex;
    align-items: center;
    justify-content: center;
    transition: 0.3s;
}
.block:hover{
    transform: scale(1.1);
}
.country{
    font-weight: 550;
    margin-left: 10px;
    margin-right: 10px;
}
.flag{
    margin-left: 5px;
}
</style>