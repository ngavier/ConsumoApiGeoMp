<meta name="layout" content="main">


<h1>Medios de Pago Offline MercadoPago Geolocalizados</h1>
<p>Direccion: ${direccion} (${lat},${lng})</p>
<p>Cantidad de sucursales disponibles a ${range}m a la redonda</p>
<table>
	<thead>
		<tr>
			<th>
				Nombre
			</th>
			<th>
				Cantidad
			</th>
		</tr>
	</thead>
	<tbody>
		<g:each in="${counts}" var="pm" status="i">
			<tr>
				<td>
					${pm.key.capitalize()}
				</td>
				<td>
					${pm.value}
				</td>
			</tr>
		</g:each>
	</tbody>
</table>

<h1>Sucursales mas cercanas</h1>
<table>
	<thead>
		<tr>
			<th>
				Nombre
			</th>
			<th>
				Sucursal
			</th>
			<th>
				Direccion
			</th>
			<th>
				Distancia
			</th>
		</tr>
	</thead>
	<tbody>
		<g:each in="${masCercanas}" var="mc">
			<tr>
				<td>
					${mc.key.capitalize()}
				</td>
				<td>
					${mc.value.description[0] }
				</td>
				<td>
					${mc.value.address.address_line[0] }
				</td>
				<td>
					${mc.value.distance[0] }
				</td>
			</tr>
		</g:each>
	</tbody>
</table>


<h1>
	Sucursal mas cercana:
</h1>
<g:if test="${masCercana != null }">
	${masCercana.key.capitalize()} -- ${masCercana.value.description[0]} - ${masCercana.value.address.address_line[0]} - A ${masCercana.value.distance[0]}m de distancia
</g:if>
<g:else>
	No se pudo obtener resultados. Porfavor, intente nuevamente.
	<g:link url="index">Volver</g:link>
</g:else>