<template>
    <div class="poland">
        <h1>Polska</h1>
        <div id="app">
            <h3>Mapa zachorowań w Polsce</h3>
            <l-map style="height: 500px;" :zoom="6" :center="[ 52.0651,  19.252522]" :options="mapOptions">
                <l-choropleth-layer :data="departmentData" titleKey="department_name" idKey="department_name"
                                    :value="value" :extraValues="extraValues" geojsonIdKey="name" :geojson="geojson"
                                    :colorScale="colorScale">
                    <template slot-scope="props">
                        <l-info-control :item="props.currentItem" :unit="props.unit" title="Województwo"
                                        placeholder="Najedź by otrzymać dane"/>
                        <l-reference-chart title="Ilość zachorowań" :colorScale="colorScale" :min="props.min"
                                           :max="props.max" position="topright"/>
                    </template>
                </l-choropleth-layer>
            </l-map>
        </div>
    </div>
</template>
<script>


    import {geojson} from '../assets/polandMapData.js'
    import {LMap} from 'vue2-leaflet';
    import 'leaflet/dist/leaflet.css';
    import {ChoroplethLayer, InfoControl, ReferenceChart} from "vue-choropleth";

    export default {
        name: "app",
        components: {
            LMap,
            'l-info-control': InfoControl,
            'l-reference-chart': ReferenceChart,
            'l-choropleth-layer': ChoroplethLayer
        },
        data() {
            return {
                geojson,
                colorScale: ["e7d090", "e9ae7b", "de7062"],
                value: {
                    key: "confirmed",
                    metric: "potwierdzonych przypadków"
                },
                extraValues: [{
                    key: "dead",
                    metric: "śmierci"
                }],
                mapOptions: {
                    attributionControl: false
                },
                currentStrokeColor: '3d3213',
                departmentData: [],
            }
        },
        beforeCreate() {
            const mapToDepartmentData = (jsonArray) => {
                jsonArray.forEach(jsonElement => {
                    let province = {
                        department_name: jsonElement.name,
                        dead: jsonElement.deadAmount,
                        confirmed: jsonElement.confirmedAmount,
                    };
                    this.departmentData.push(province);
                });
                console.log(this.departmentData);
            };

            fetch('http://longhorn.pl:7331/covid/province')
                .then((response) => {
                    return response.json();
                })
                .then((data) => {
                    mapToDepartmentData(data);
                });
        }
    }
</script>
<style>
    #map {
        background-color: #eee;
    }
</style>