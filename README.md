# ChienStagram ?

## Objectifs

L'objectif de cet exercice est d'implémenter de façon incrémentale une application Android qui s'apparente à un Instagram avec des photos de chien.
Ce développement va permettre d'acquérir des bonnes pratiques de code et de découvrir ou de consolider les connaissances en :
- __*Clean Archi*__ : couches presentation, domain et data et injection de dépendance 
- __tests unitaires__ : avec Junit et Mockito
- __gestion des flux de données__ : Coroutine et Flow
- __gestion de la vue__ : vue XML classique et *Jetpack Compose*

## Présentation de l'application

__ChienStagram__ est une application Android donc le front-end qui permet d'afficher une __liste de posts de chien__, c'est-à-dire une photo d'un chien (ou chat) postée par une utilisateur, à une certaine date, avec une description et des tags. Chaque utilisateur peut en outre liker et laisser un commentaire sur un post. 

Dans l'univers de ChienStagram, la RGPD n'existe pas. Chaque utilisateur a un prénom, nom, genre, date de naissance, e-mail, téléphone et adresse physique.

ChienStagram est découpé en 3 écrans principaux :
- L'écran d'accueil : __*home screen*__ qui contient la liste des posts
- L'écran de post : __*post screen*__ qui permet de visualiser l'image en grand et le détail d'un post. Il est accessible au clic sur un post depuis l'écran d'accueil
- L'écran de profil : __*user screen*__ où l'on peut voir les informations de l'utilisateur. Il est accessible par un clic sur n'importe quel avatar sur les deux précédents écrans. 

Voici un exemple d'interface pour l'application. Il est possible de changer les formes, les tailles, les couleurs ou faire apparaîte des informations de différentes manières ou de les masquer :

| home screen | post screen | user screen |
|:-----------:|:-----------:|:-----------:|
| ![home light](screenshots/home_light.jpg) | ![post light](screenshots/post_light.jpg) | ![user light](screenshots/user_light.jpg) |

## Découpage de l'implémentation

L'architecture du projet a été mis en place et le premier écran a été développé. L'objectif est de développer les deux autres écrans en commençant par la couche domain, puis data et enfin présentation.
