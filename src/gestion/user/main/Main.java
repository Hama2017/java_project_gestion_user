package gestion.user.main;

import gestion.user.dao.IRole;
import gestion.user.dao.IUser;
import gestion.user.dao.RoleImpl;
import gestion.user.dao.UserImpl;
import gestion.user.entites.Algorithm;
import gestion.user.entites.Role;
import gestion.user.entites.User;

import java.util.Scanner;

public class Main extends Algorithm {
    public static void main(String[] args)  {

        boolean reponse=false;
        int get,choix;
        Role role = new Role();
        User user = new User();
        IUser daoUser = new UserImpl();
        IRole daoRole = new RoleImpl();
        Scanner scanner = new Scanner(System.in);

do {
    do {

        System.out.println("\n");

        System.out.println(" $$$$$$\\  $$$$$$$$\\  $$$$$$\\ $$$$$$$$\\ $$$$$$\\  $$$$$$\\  $$\\   $$\\       $$\\   $$\\ $$$$$$$$\\ $$$$$$\\ $$\\       $$$$$$\\  $$$$$$\\   $$$$$$\\ $$$$$$$$\\ $$$$$$$$\\ $$\\   $$\\ $$$$$$$\\\n" +
                "$$  __$$\\ $$  _____|$$  __$$\\\\__$$  __|\\_$$  _|$$  __$$\\ $$$\\  $$ |      $$ |  $$ |\\__$$  __|\\_$$  _|$$ |      \\_$$  _|$$  __$$\\ $$  __$$\\\\__$$  __|$$  _____|$$ |  $$ |$$  __$$\\\n" +
                "$$ /  \\__|$$ |      $$ /  \\__|  $$ |     $$ |  $$ /  $$ |$$$$\\ $$ |      $$ |  $$ |   $$ |     $$ |  $$ |        $$ |  $$ /  \\__|$$ /  $$ |  $$ |   $$ |      $$ |  $$ |$$ |  $$ |\n" +
                "$$ |$$$$\\ $$$$$\\    \\$$$$$$\\    $$ |     $$ |  $$ |  $$ |$$ $$\\$$ |      $$ |  $$ |   $$ |     $$ |  $$ |        $$ |  \\$$$$$$\\  $$$$$$$$ |  $$ |   $$$$$\\    $$ |  $$ |$$$$$$$  |\n" +
                "$$ |\\_$$ |$$  __|    \\____$$\\   $$ |     $$ |  $$ |  $$ |$$ \\$$$$ |      $$ |  $$ |   $$ |     $$ |  $$ |        $$ |   \\____$$\\ $$  __$$ |  $$ |   $$  __|   $$ |  $$ |$$  __$$<\n" +
                "$$ |  $$ |$$ |      $$\\   $$ |  $$ |     $$ |  $$ |  $$ |$$ |\\$$$ |      $$ |  $$ |   $$ |     $$ |  $$ |        $$ |  $$\\   $$ |$$ |  $$ |  $$ |   $$ |      $$ |  $$ |$$ |  $$ |\n" +
                "\\$$$$$$  |$$$$$$$$\\ \\$$$$$$  |  $$ |   $$$$$$\\  $$$$$$  |$$ | \\$$ |      \\$$$$$$  |   $$ |   $$$$$$\\ $$$$$$$$\\ $$$$$$\\ \\$$$$$$  |$$ |  $$ |  $$ |   $$$$$$$$\\ \\$$$$$$  |$$ |  $$ |\n" +
                " \\______/ \\________| \\______/   \\__|   \\______| \\______/ \\__|  \\__|       \\______/    \\__|   \\______|\\________|\\______| \\______/ \\__|  \\__|  \\__|   \\________| \\______/ \\__|  \\__|\n" +
                "\n" +
                "\n");

        System.out.println(
                "\nBIENVENUE DANS LE SYSTEME DE GESTION D'UTILISATEURS BOULAKODARADIARAL V2\n" +
                        "1 - GESTION DES ROLES \n" +
                        "2 - GESTION DES UTILISATEURS\n"
        );
        navPRole:
        {
            System.out.println("SAISIR CHOIX : ");
            choix = scanner.nextInt();

            switch (choix) {

                case 1:
                    System.out.println("\n" +
                            "1 - Ajouter un role\n" +
                            "2 - Afficher tout les roles\n" +
                            "3 - Afficher un role\n" +
                            "4 - Modifier un role\n" +
                            "5 - Supprimer un role\n"
                            );

                    System.out.println("SAISIR CHOIX : ");
                    int choix2 = scanner.nextInt();
                    switch (choix2) {
                        case 1:
                            String name;
                            System.out.println("NAME : ");
                            scanner.nextLine();
                            name = scanner.nextLine();
                            role.setName(name);
                            if (daoRole.createRole(role)) System.out.println("Role ajouté avec success");
                            break;

                        case 2:
                            System.out.println("\n");
                            System.out.println("CHAGERGEMENT EN COURS \n");
                            System.out.println("Liste des Roles : il y'a " + daoRole.showAllRole().size() + " roles ");

                            for (Role r : daoRole.showAllRole()) {
                                System.out.println("\n");
                                System.out.println("---------------------------------------------");
                                System.out.println("ID = " + r.getId());
                                System.out.println("NAME = " + r.getName().toUpperCase());
                                System.out.println("DATE_CREATED = " + r.getDateCreated());
                                System.out.println("DATE_LAST_EDIT = " + r.getDateLastEdit());
                                System.out.println("---------------------------------------------");
                            }

                            break;

                        case 3:
                            int idRole;

                            do {

                                System.out.println("SAISIR ID DU ROLE A AFFICHER :");
                                idRole = scanner.nextInt();
                                System.out.println("CHAGERGEMENT EN COURS \n");
                                if(!isRoleExist(idRole)) System.out.println("ERREUR ID INCORRECT ! REESAYER");

                            }while(!isRoleExist(idRole));

                            daoRole.showRoleById(idRole);

                            System.out.println("\n");
                            System.out.println("---------------------------------------------");
                            System.out.println("ID = " + daoRole.showRoleById(idRole).getId());
                            System.out.println("NAME = " + daoRole.showRoleById(idRole).getName().toUpperCase());
                            System.out.println("DATE_CREATED = " + daoRole.showRoleById(idRole).getDateCreated());
                            System.out.println("DATE_LAST_EDIT = " + daoRole.showRoleById(idRole).getDateLastEdit());
                            System.out.println("---------------------------------------------");

                            break;

                        case 4:
                            do {

                                System.out.println("SAISIR ID DU ROLE A MODIFIER :");
                                idRole = scanner.nextInt();
                                System.out.println("CHAGERGEMENT EN COURS \n");

                                if(!isRoleExist(idRole)) System.out.println("ERREUR ID INCORRECT ! REESAYER");

                            }while(!isRoleExist(idRole));
                            String newName;
                            System.out.println("NEW NAME : ");
                            scanner.nextLine();
                            newName = scanner.nextLine();
                            if (daoRole.updateRole(idRole, newName)) System.out.println("Role modifié avec success");

                            break;

                        case 5:
                            do {

                                System.out.println("SAISIR ID DU ROLE A SUPPRIMER :");
                                idRole = scanner.nextInt();
                                System.out.println("CHAGERGEMENT EN COURS \n");

                                if(!isRoleExist(idRole)) System.out.println("ERREUR ID INCORRECT ! REESAYER");

                            }while(!isRoleExist(idRole));
                            System.out.println("CHAGERGEMENT EN COURS \n");

                            if (daoRole.deleteRole(idRole)) System.out.println("Role Supprimer avec success");

                            break;

                    }
                    break;

                case 2:
                    System.out.println("\n" +
                            "1 - Ajouter un utilisateur\n" +
                            "2 - Afficher tout les utilisateurs\n" +
                            "3 - Afficher un utilisateur\n" +
                            "4 - Modifier un utilisateur\n" +
                            "5 - Supprimer un utilisateur\n"
                    );
                    int choix3;
                    System.out.println("SAISIR CHOIX : ");
                    choix3 = scanner.nextInt();
                    switch (choix3){
                        case 1:
                            int idRole;
                            scanner.nextLine();
                            String adressEmail;
                            String password;
                            System.out.println("E-MAIL : ");
                            adressEmail = scanner.nextLine();
                            System.out.println("APPUYER SUR ENTRER POUR CONTINUER");
                            scanner.nextLine();
                            System.out.println("CHAGERGEMENT EN COURS \n");
                            do {
                                System.out.println("Liste des Roles : \n");
                                for (Role r : daoRole.showAllRole()) {
                                    System.out.println( r.getId() + ") "+ r.getName().toUpperCase());
                                }
                                System.out.println("\nCHOSIR ID ROLE : ");
                                idRole = scanner.nextInt();

                                if(!isRoleExist(idRole)) System.out.println("\nERREUR ID INCORRECT ! REES2AYER");

                            }while(!isRoleExist(idRole));

                            System.out.println("PASSWORD : ");
                            scanner.nextLine();
                            password = scanner.nextLine();
                            user.setEmail(adressEmail);
                            user.setPassword(password);
                            user.setPasswordHashed(password);
                            user.setId_role(idRole);
                            if (daoUser.createUser(user)) System.out.println("Utilisateur ajouté avec success");
                            break;


                        case 2:
                            System.out.println("CHAGERGEMENT EN COURS \n");

                            System.out.println("\n");
                            System.out.println("Liste des Utilisateurs : il y'a " + daoUser.showAllUser().size() + " utilisateurs ");
                            for (User u : daoUser.showAllUser()) {
                                System.out.println("\n");
                                System.out.println("---------------------------------------------");
                                System.out.println("ID_USER : " + u.getId());
                                System.out.println("ID_ROLE : " + u.getId_role());
                                System.out.println("ROLE : " + daoRole.showRoleById(u.getId_role()).getName());
                                System.out.println("EMAIL : " + u.getEmail().toUpperCase());
                                System.out.println("PASSWORD : " + u.getPassword());
                                System.out.println("PASSWORD_HASHED :  " + u.getPasswordHashed());
                                System.out.println("DATE_CREATED : " + u.getDateCreated());
                                System.out.println("DATE_LAST_EDIT : " + u.getDateLastEdit());
                                System.out.println("---------------------------------------------");
                            }
                            break;

                        case 3:
                            int idUser;
                            do {

                                System.out.println("SAISIR ID DE L'UTILISATEUR A AFFICHER :");
                                idUser = scanner.nextInt();
                                System.out.println("CHAGERGEMENT EN COURS \n");

                                if(!isUserExist(idUser)) System.out.println("ERREUR ID INCORRECT ! REESAYER");

                            }while(!isUserExist(idUser));
                            daoUser.showUserById(idUser);
                            System.out.println("---------------------------------------------");
                            System.out.println("ID_USER : " +  daoUser.showUserById(idUser).getId());
                            System.out.println("ID_ROLE : " +  daoUser.showUserById(idUser).getId_role());
                            System.out.println("ROLE : " + daoRole.showRoleById(daoUser.showUserById(idUser).getId_role()).getName());
                            System.out.println("EMAIL : " +  daoUser.showUserById(idUser).getEmail().toUpperCase());
                            System.out.println("PASSWORD : " +  daoUser.showUserById(idUser).getPassword());
                            System.out.println("PASSWORD_HASHED :  " +  daoUser.showUserById(idUser).getPasswordHashed());
                            System.out.println("DATE_CREATED : " +  daoUser.showUserById(idUser).getDateCreated());
                            System.out.println("DATE_LAST_EDIT : " +  daoUser.showUserById(idUser).getDateLastEdit());
                            System.out.println("---------------------------------------------");
                            break;

                        case 4:
                            do {

                                System.out.println("SAISIR ID DE L'UTILISATEUR A MODIFIER :");
                                idUser = scanner.nextInt();
                                System.out.println("CHAGERGEMENT EN COURS \n");
                                if(!isUserExist(idUser)) System.out.println("ERREUR ID INCORRECT ! REESAYER");

                            }while(!isUserExist(idUser));
                            System.out.println("E-MAIL : ");
                            scanner.nextLine();
                            adressEmail = scanner.nextLine();
                            System.out.println("APPUYER SUR ENTRER POUR CONTINUER");
                            do {
                                System.out.println("Liste des Roles : \n");
                                for (Role r : daoRole.showAllRole()) {
                                    System.out.println( r.getId() + ") "+ r.getName().toUpperCase());
                                }
                                System.out.println("\nCHOSIR ID ROLE : ");
                                idRole = scanner.nextInt();

                                if(!isRoleExist(idRole)) System.out.println("\nERREUR ID INCORRECT ! REES2AYER");

                            }while(!isRoleExist(idRole));

                            System.out.println("PASSWORD : ");
                            scanner.nextLine();
                            password = scanner.nextLine();
                           String passwordHashed = crypter(password);
                            if (daoUser.updateUser(idUser,adressEmail,password,passwordHashed,idRole)) System.out.println("Utilisateur modifié avec success");

                            break;

                        case 5:
                            do {

                                System.out.println("SAISIR ID DE L'UTILISATEUR A SUPPRIMER :");
                                idUser = scanner.nextInt();
                                System.out.println("CHAGERGEMENT EN COURS \n");
                                if(!isUserExist(idUser)) System.out.println("ERREUR ID INCORRECT ! REESAYER");

                            }while(!isUserExist(idUser));
                            System.out.println("CHAGERGEMENT EN COURS \n");
                            if (daoUser.deleteUser(idUser)) System.out.println("Utilisateur Supprimer avec success");

                    }
                    break;


            }

        }

    } while (choix > 2 || choix < 1);

    System.out.println("Voulez vous revenir au MENU PRINCIPAL si oui tapez 1 sinon tapez 0 POUR QUITTER");
    get= scanner.nextInt();
    reponse=get==1? true : false;

    System.out.println("$$$$$$$\\ $$\\     $$\\       $$\\   $$\\  $$$$$$\\  $$\\      $$\\  $$$$$$\\      $$\\   $$\\  $$$$$$\\   $$$$$$\\   $$$$$$\\  \n" +
            "$$  __$$\\\\$$\\   $$  |      $$ |  $$ |$$  __$$\\ $$$\\    $$$ |$$  __$$\\     $$$\\  $$ |$$  __$$\\ $$  __$$\\ $$  __$$\\ \n" +
            "$$ |  $$ |\\$$\\ $$  /       $$ |  $$ |$$ /  $$ |$$$$\\  $$$$ |$$ /  $$ |    $$$$\\ $$ |$$ /  $$ |$$ /  \\__|$$ /  $$ |\n" +
            "$$$$$$$\\ | \\$$$$  /        $$$$$$$$ |$$$$$$$$ |$$\\$$\\$$ $$ |$$$$$$$$ |    $$ $$\\$$ |$$$$$$$$ |\\$$$$$$\\  $$$$$$$$ |\n" +
            "$$  __$$\\   \\$$  /         $$  __$$ |$$  __$$ |$$ \\$$$  $$ |$$  __$$ |    $$ \\$$$$ |$$  __$$ | \\____$$\\ $$  __$$ |\n" +
            "$$ |  $$ |   $$ |          $$ |  $$ |$$ |  $$ |$$ |\\$  /$$ |$$ |  $$ |    $$ |\\$$$ |$$ |  $$ |$$\\   $$ |$$ |  $$ |\n" +
            "$$$$$$$  |   $$ |          $$ |  $$ |$$ |  $$ |$$ | \\_/ $$ |$$ |  $$ |$$\\ $$ | \\$$ |$$ |  $$ |\\$$$$$$  |$$ |  $$ |\n" +
            "\\_______/    \\__|          \\__|  \\__|\\__|  \\__|\\__|     \\__|\\__|  \\__|\\__|\\__|  \\__|\\__|  \\__| \\______/ \\__|  \\__|\n" +
            "                                                                                                                  \n" +
            "                                                                                                                  \n" +
            "                                                                                                                  ");
} while(reponse);



    }
}