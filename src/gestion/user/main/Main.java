package gestion.user.main;

import gestion.user.dao.IRole;
import gestion.user.dao.IUser;
import gestion.user.dao.RoleImpl;
import gestion.user.dao.UserImpl;
import gestion.user.entites.Role;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IUser daoUser = new UserImpl();
        IRole daoRole = new RoleImpl();
        Scanner scanner = new Scanner(System.in);
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        int choix;
        do {

            System.out.println(
                    "\nBIENVENUE DANS LE SYSTEME DE GESTION D'UTILISATEURS BOULAKODARADIARAL V2\n" +
                            "1 - GESTION DES ROLES \n" +
                            "2 - GESTION DES UTILISATEURS\n"
            );
            navPRole:{
            System.out.println("SAISIR CHOIX : ");
            choix = scanner.nextInt();

                switch (choix) {

                    case 1:
                        System.out.println("\n" +
                                "1 - Ajouter un role\n" +
                                "2 - Afficher tout les roles\n" +
                                "3 - Afficher un role\n" +
                                "4 - Modifier un role\n" +
                                "5 - Supprimer un role\n" +
                                "6 - Retour\n");
                        int choix2;
                        System.out.println("SAISIR CHOIX : ");
                        choix2 = scanner.nextInt();
                        switch (choix2) {
                            case 1:
                                Role role = new Role();
                                String dateCreated = dateObj.format(formatter);
                                String name;
                                System.out.println("NAME : ");
                                scanner.nextLine();
                                name = scanner.nextLine();
                                role.setName(name);
                                role.setDateCreated(dateCreated);
                                role.setDateLastEdit(dateCreated);
                                if (daoRole.createRole(role)) System.out.println("Role ajouté avec success");
                                break;

                            case 2:
                                System.out.println("\n");
                                System.out.println("Liste des Roles : ");

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
                                int choix3;
                                System.out.println("SAISIR ID DU ROLE:");
                                choix3 = scanner.nextInt();
                                daoRole.showRoleById(choix3);

                                System.out.println("\n");
                                System.out.println("---------------------------------------------");
                                System.out.println("ID = " + daoRole.showRoleById(choix3).getId());
                                System.out.println("NAME = " + daoRole.showRoleById(choix3).getName().toUpperCase());
                                System.out.println("DATE_CREATED = " + daoRole.showRoleById(choix3).getDateCreated());
                                System.out.println("DATE_LAST_EDIT = " + daoRole.showRoleById(choix3).getDateLastEdit());
                                System.out.println("---------------------------------------------");

                                break;

                            case 4:
                                int choix4;
                                String newName;
                                System.out.println("SAISIR ID DU ROLE A MODIFIER :");
                                choix4 = scanner.nextInt();
                                String dateLastEdit = dateObj.format(formatter);
                                System.out.println("NEW NAME : ");
                                scanner.nextLine();
                                newName = scanner.nextLine();
                                if (daoRole.updateRole(choix4,newName)) System.out.println("Role modifié avec success");

                                break;

                            case 5:
                                int choix5;
                                System.out.println("SAISIR ID DU ROLE A SUPPRIMER :");
                                choix5 = scanner.nextInt();
                                if (daoRole.deleteRole(choix5)) System.out.println("Role Supprimer avec success");

                                break;

                        }
                        break;



                }

            }

        } while (choix > 2 || choix < 1);

    }
}