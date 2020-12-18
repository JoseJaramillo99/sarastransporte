function validar(){

    var correo = document.getElementById("correo").value;
    var clave = document.getElementById("clave").value;

    expresion = /\w+@\w+.+[a-z]/;

    if(correo === "" || clave === ""){
        alert("Todos los campos son obligatorios");
        return false;
    }
    else if (correo.length>30){
        alert("El correo tiene muchos caracteres");
        return false;
    }
    else if(!expresion.test(correo)){
        alert("El correo no es valido");
        return false;
    }
    else if(clave.length>=9){
        alert("Contraseña demasiado larga");
        return false;
    }
    else if(clave.length<=5){
        alert("Contraseña demasiado corta");
        return false;
    }
    else if(correo==="sara@gmail.com" && clave==="12345678"){
        alert("Ingreso correcto")
        window.location.href="comprador/index.xhtml";
    }
    else if(correo==="yanny@gmail.com" && clave==="123456"){
        alert("Ingreso correcto")
        window.location.href="vendedor/index.xhtml";
    }
    else if(correo==="sebas@gmail.com" && clave==="1234560"){
        alert("Ingreso correcto")
        window.location.href="principal/index.xhtml";
    }
    else{
        alert("Contraseña incorrecta");
    }
}