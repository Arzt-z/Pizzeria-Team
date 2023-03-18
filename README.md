# Pizzeria-Team
trabajo final en equipo de Poo  
  
git config --global user.email "ooalexis.samaoo@gmail.com" //cambiar email  
git config --global user.name "Alexis Corzas"              //cambiar nombre  
git clone                                                  //clonar un repositorio  
git init                                                   //crear nuevo repositorio

git status                                                 //mostrar estado de los archivos  
git add filename.txt                                       //añadir un archivo al repositorio  

git commit                                                 //commit con comentario detallado  
git commit -m 'commentario'                                //commit con pequeño comentario  
git commit -a                                              //commit todos los archivos modificados que estan trackeados  
git commit -a -m 'comentario'                              // hace el -a y -m juntos  

git log                                                    //muestra los commits del repositorio  
git rm filename.txt                                        //remueve un archivo de ser trackeados commit para aplicar el cambio  
git mv filename.txt newfilename.txt                        //cambiar nombre de un archivo, tambien sirve para moverlo  
ls -l                                                      //listar archivos  

git pull                                                   // actualiza el repositorio local con los cambios del online es  
                                                              -importante antes de subir tus cambios bajar los que hay, por si
                                                              -alguien mas subio algun cambio mientras.

git push                                                   //sube tus cambios al repositorio online, primero tienes que hacer commit
                                                              -de los cambios que hiciste para que aparescan.



/////////////////////////////////////////////////////////////////////////////////  
para el mensaje en el commit detallado  
  
primera linea un mensaje corto que describa los cambios de forma resumida  
  
tercera linea mensaje descriptivo de los cambios siempre dejar una linea vacia  
entre la linea 2 y 3, este mensaje puede ser largo de varias lineas de  
ser necesario.  
