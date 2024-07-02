Spring boot project for managing a companie's assets

Run Instructions:
1. Install a mysql server that runs the server on port: 3306 and host: localhost
2. Configure the database access by modifying user and password on application.properties file
3. Run the application.

Use Instructions:

1. For creating an asset, send a post request with the url with params like: "localhost:8080/demo/new?name=name&tipo=tipo1&descripcion=descript.&serial=serial1&numeroInternoInventario=100&peso=2&alto=3&ancho=4&largo=5&valor=6&fechaDeCompra=12-05-1972"

2. For modifying the asset, send a post request with url params like: localhost:8080/demo/update?assetId=1&name=nameUpdated&tipo=tipo1Updated&descripcion=descript.&serial=serial1&numeroInternoInventario=100&peso=2&alto=3&ancho=4&largo=5&valor=6&fechaDeCompra=12-05-1973

3. For deleting the asset, send a delete url with params like: localhost:8080/demo/delete?assetId=1

4. For Listing 1 asset, send a get request with and url like: localhost:8080/demo/get?assetId=2

5. For Listing all assets, send a get request with url: localhost:8080/demo/all

6. For filtering by 'tipoDeCompra', with a get request: localhost:8080/demo/findByTipoDeCompra?tipoCompra=tipo1

7. For filtering by 'findByFechaCompra' with a get request: localhost:8080/demo/findByFechaCompra?fechaCompra=2024-07-02

8. For filtering by serial with a get request: localhost:8080/demo/findBySerial?serial=serial1