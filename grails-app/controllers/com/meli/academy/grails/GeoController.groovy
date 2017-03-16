package com.meli.academy.grails

import com.google.common.collect.Multiset.Entry

import groovy.json.JsonSlurper

class GeoController {
	
	def mapService
	def meliService
    def index() { }
	
	def sucursalesCerca(){
		
		def address = params.address == null ? "" : params.address
		def counts = null
		def masCercana = null
		def masCercanas
		def point
		
		if(address != ""){
			
			point = mapService.getLatLong(address)
			counts = meliService.count(point.lat,point.lng,params.rango)
			masCercanas = meliService.closest(point.lat,point.lng,params.rango)
			def minDistance = Double.parseDouble(params.rango) //Guardo el maximo posible para empezar a buscar la menor
			
			for (mc in masCercanas){
				Double dist = Double.parseDouble(mc.value.distance[0])
				if(dist < minDistance) {
					masCercana = mc
					minDistance = Double.parseDouble(mc.value.distance[0])
				}
			}
		}
		[counts:counts, masCercanas:masCercanas, masCercana:masCercana,lat:point.lat,lng:point.lng,range:params.rango,direccion:params.address]
	}
	
	def capitales() {
		
		render 'Capitales de Emi'
	}
}
