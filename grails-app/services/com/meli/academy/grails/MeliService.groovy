package com.meli.academy.grails

import com.sun.corba.se.pept.transport.OutboundConnectionCache

import grails.transaction.Transactional
import groovy.json.JsonSlurper

@Transactional
class MeliService {

	def paymentMethodsIds = ["cargavirtual","pagofacil","rapipago","redlink","bapropagos"] //Chequear id de provinciaNet
	
    def count(lat,lng,rng){
		Map result = [:]
		for(String id : paymentMethodsIds){
			def url = new URL("https://api.mercadolibre.com/sites/MLA/payment_methods/"+id+"/agencies/count?near_to="+lat+","+lng+","+rng)
			
			def connection = (HttpURLConnection)url.openConnection()
			
			connection.setRequestMethod("GET")
			connection.setRequestProperty("Accept", "application/json")
			connection.setRequestProperty("User-Agent", "Mozilla/5.0")
			
			JsonSlurper json = new JsonSlurper()
			Map map = (HashMap) json.parse(connection.getInputStream())
			
			result.put(id, map.count)
		}
		return result
	}
	
	def closest(lat,lng,rng){
		Map result = [:]
		for(String id : paymentMethodsIds){
			def url = new URL("https://api.mercadolibre.com/sites/MLA/payment_methods/"+id
				+"/agencies/?near_to="+lat+","+lng+","+rng+"&limit=1")
			
			def connection = (HttpURLConnection)url.openConnection()
			
			connection.setRequestMethod("GET")
			connection.setRequestProperty("Accept", "application/json")
			connection.setRequestProperty("User-Agent", "Mozilla/5.0")
			
			JsonSlurper json = new JsonSlurper()
			Map map = (HashMap) json.parse(connection.getInputStream())
			if(map.results)
				result.put(id, map.results)
			
		}
		//println result
		return result
	}
}
