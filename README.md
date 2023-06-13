# Proyecto final de Maquina Expendedora
## Integrantes del grupo: Daniel Lavín, Lydia García y Paula Qing Diestro

+ FaultException, JamException y NoMoneyException: Excepciones para falta de productos, atasco en la máquina y para cuando no hay dinero.
+ Incidence: Posibles incidencias que se puedan dar y establece la hora y fecha. State: Los estados en los que la máquina puede estar.
+ Product: Clase abstracta en la que se establecen el nombre, precio, id y las unidades. Tiene constructor, getter y setter.
+ Accessories: extiende de Product, establece el número de cajas y hace constructor.
+ Drinks: Extiende de Product, establece dos variables, alcohol y milimeters, consta de constructor, getter y setter.
+ Food: extiende de Product, establece los gramos, consta de constructor, getter y setter.
+ Gluten y GlutenFree: Extiende de la clase Food y tiene constructor.
+ Coin: establece los valores que el dinero puede aceptar y la cantidad de monedas y billetes por máquina.
+ Machine: implementa salable, establece un id, crea un ArrayList de tipo Product, una variable de tipo Money y otra de tipo State. Consta de un constructor getter y setter. El método listProducts, lista los productos, el machineInformation, nos da información de la máquina. El BuyProduct, nos permite comprar un producto sino hay atasco y queda stock. El changeManagement, nos devuelve el cambio cuando realizamos una compra. PossibleJam y possibleFault, crea una probabilidad de atasco y de que no haya stock, y el getProductPrice, nos muestra el precio de un producto.
+ Salable: crea un método tipo Money y dos del tipo State.
+ Money: crea una matriz de tipo float y otra de tipo entero. El método insert, añade monedas y el remove las quita. El getTotal nos muestra el dinero total que tiene la máquina. El add y el sustract, añade y quita y el método information, nos da el valor de la moneda o billete introducido.
+ Management: crea 2 ArrayList, uno de tipo machine y otro de tipo Incidence. En el método Management, se crean 2 ArrayList, una de tipo Product y la otra de tipo Drinks, se inserta el dinero en las máquinas y se establecen los productos, en el BuyProduct, se compra un producto y en el machineInformation nos da el estado de la máquina.
+ Main: pequeña simulación que contine a todas las clases para comprobar que funcioné.
