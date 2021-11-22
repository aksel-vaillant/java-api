#Compte rendu du TP
        - Réalisé par Aksel Vaillant - ENSIM 

##Etape 5 - Description des dépendances
- Spring web : permet de fournir une infrastructure pour compiler et construire un site web
- Spring data JPA : permet d'implémenter une couche d'accès aux données
- Hibernate validation : permet de créer les balises "form" pour le web
- H2 database : permet de créer en java une base de données dans la mémoire
- Spring devtools : permet d'améliorer l'DX (developer experience)
- Thymeleaf : permet de travailler dans des environnements web et en offline pour simuler un siteweb

##Etape 13 - Controller
1 - URL d'appel  - @GetMapping("/greeting")

2 - Sélection du fichier HTML - return "greeting";

3 - Envoie des informations - model.addAttribute("nomTemplate", nameGET);

##Etape 17 - H2
Un nouveau tableau de configuration a fait son apparition 

##Etape 30 - Ajout de Bootstrap

		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>bootstrap</artifactId>
			<version>5.1.3</version>
		</dependency>
		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>webjars-locator</artifactId>
			<version>0.30</version>
		</dependency>

Dans chaque fichier j'ajoute également dans le header...

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" />

