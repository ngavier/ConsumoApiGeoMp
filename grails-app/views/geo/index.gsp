<meta name="layout" content="main">
<g:form action="sucursalesCerca" method="POST">
	<label for="address">Direccion: </label>
	<g:textField name="address" id="address" />
	<label for="rango" >Rango: </label>
	<g:field type="number" name="rango" id="rango"/>
	<g:submitButton name="submit"/>
</g:form>