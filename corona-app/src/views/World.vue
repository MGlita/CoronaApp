<template>
  <div class="world">
    <div class="header"><p>Świat</p></div>
    <div class="secondary"><p>Strona przedstawiająca zachorowania w wybranych krajach</p></div>
    <div class="countries">
      <CountryBlock v-for="item in countries" v-bind:key="item.id" :country="item.name" :flag="item.flag"></CountryBlock>
    </div>
  </div>
</template>
<script>
// @ is an alias to /src
import CountryBlock from '@/components/CountryBlock.vue'

export default {
  name: 'World',
  components: {
    CountryBlock
  },
  data(){
    return{
    countries:[
      {
        "name":"Hiszpania",
        "flag":"spain.png"
      },
      {
        "name":"Portugalia",
        "flag":"portugal.png"
      },
      { 
        "name":"Francja",
        "flag":"france.png"
      },
      {
        "name":"Niemcy",
        "flag":"germany.png"
      },
      {
        "name":"Wielka Brytania",
        "flag":"britain.png"
      }
    ]}
  }
}
</script>
<style scoped>
.world{
  margin-top:30px;
}
.header{
  font-size: 70px;
  font-weight: 500;
}
.secondary{
  font-size: 30px;
  font-weight: 300;
  margin-top:60px;
}
.countries{
  margin-top: 100px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}
</style>