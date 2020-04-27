<template>
    <div class="app">
        <canvas ref="canvas" width="900" height="400"></canvas>
    </div>
</template>

<script>
    import { Bar } from 'vue-chartjs'

    export default {
        extends: Bar,
        props: {
            chartdata: {
                type: Object,
                default: null
            },
            options: {
                responsive: true,
                maintainAspectRatio: false
            }
        },
        mounted () {
            this.renderChart(this.chartdata, this.options)
        }
    }
</script>

<style scoped>

</style>