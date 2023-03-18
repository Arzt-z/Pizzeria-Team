# Pizzeria-Team
trabajo final en equipo de Poo  
  
git config --global user.email "ooalexis.samaoo@gmail.com" //cambiar email  
git config --global user.name "Alexis Corzas"              &emsp;&emsp;//cambiar nombre  
git clone                                                &emsp;&emsp;&emsp;&emsp;  //clonar un repositorio  
git init                                              &emsp;&emsp;&emsp;&emsp;     //crear nuevo repositorio

git status                                          &emsp;&emsp;&emsp;&emsp;       //mostrar estado de los archivos  
git add filename.txt                               &emsp;&emsp;&emsp;        //añadir un archivo al repositorio  

git commit                                         &emsp;&emsp;&emsp;        //commit con comentario detallado  
git commit -m 'commentario'                         &emsp;&emsp;      //commit con pequeño comentario  
git commit -a                                       &emsp;&emsp;&emsp;       //commit todos los archivos modificados que estan trackeados  
git commit -a -m 'comentario'                        &emsp;&emsp;      // hace el -a y -m juntos  

git log                                               &emsp;&emsp;&emsp;     //muestra los commits del repositorio  
git rm filename.txt                                  &emsp;&emsp;      //remueve un archivo de ser trackeados commit para aplicar el cambio  
git mv filename.txt newfilename.txt                   &emsp;     //cambiar nombre de un archivo, tambien sirve para moverlo  
ls -l                                                &emsp;&emsp;&emsp;      //listar archivos  

git pull                                            &emsp;&emsp;&emsp;       // actualiza el repositorio local con los cambios del online es  
                                                     &emsp;&emsp;&emsp;&emsp;         -importante antes de subir tus cambios bajar los que hay, por si
                                                      &emsp;&emsp;&emsp;&emsp;        -alguien mas subio algun cambio mientras.

git push                                         &emsp;&emsp;&emsp;          //sube tus cambios al repositorio online, primero tienes que hacer commit
                                                    &emsp;&emsp;&emsp;&emsp;          -de los cambios que hiciste para que aparescan.



/////////////////////////////////////////////////////////////////////////////////  
para el mensaje en el commit detallado  
  
primera linea un mensaje corto que describa los cambios de forma resumida  
  
tercera linea mensaje descriptivo de los cambios siempre dejar una linea vacia  
entre la linea 2 y 3, este mensaje puede ser largo de varias lineas de  
ser necesario.  
