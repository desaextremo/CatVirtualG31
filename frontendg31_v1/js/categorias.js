//Define variables para acceder al elemento a través de su atributo id
let new_category = document.getElementById("new")
let save_category = document.getElementById("save")
let delete_category = document.getElementById("delete")
let list_data = document.getElementById("list_data")

//la primera vez que la pagina carga y se muestra al usuario solo estara visible la tabla para consultar 
//los datos
new_category.style.display="none"
save_category.style.display="none"
delete_category.style.display="none"
list_data.style.display="block"