Spring boot project for paginating a pokemon's query

Run Instructions:
1. Install java version 17
2. Run the spring boot application .
3. the application must run on  http://localhost:8080

Use Instructions:

1. For Querying the list of pokemon http://localhost:8080/pokemon/all?page=0&size=10
2. To query the second page and the size the parameters must change ?page=<page you want>&size=<size you want>

JUSTIFICACIÓN DE LOS PATRONES DE DISEÑO:

Patron singleton: Se está haciendo uso de este patrón puesto que se está usando la anotación @Service en PokemonService, esto le indica a la librería Spring que solo puede haber una instancia de este servicio haciendo uso de este patrón

Patron Factory: Se está haciendo uso de este patrón para crear objetos de tipo Pokemon encapsulando esta funcionalidad y haciendola mas facil de modificar.
