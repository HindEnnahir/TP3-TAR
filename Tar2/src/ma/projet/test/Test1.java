package ma.projet.test;

import java.util.Date;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import ma.projet.beans.MariagePK;
import ma.projet.service.FemmeService;
import ma.projet.service.HommeService;
import ma.projet.service.MariageService;
import ma.projet.util.HibernateUtil;

public class Test1 {

    public static void main(String[] args) {

        FemmeService fs = new FemmeService();
        Femme f1 = new Femme("Choufani", "Zineb", "0568899890", "bd_casa", new Date("1973/04/09"));
        Femme f2 = new Femme("Doe", "Jane", "1234567890", "123 Main St", new Date("1985/09/15"));
        Femme f3 = new Femme("Smith", "Emily", "9876543210", "456 Elm St", new Date("1990/02/28"));
        Femme f4 = new Femme("Johnson", "Jessica", "5555555555", "789 Oak St", new Date("1978/07/10"));
        Femme f5 = new Femme("Brown", "Sophia", "3333333333", "567 Pine St", new Date("1995/03/22"));
        Femme f6 = new Femme("Garcia", "Isabella", "7777777777", "321 Cedar St", new Date("1982/11/08"));
        Femme f7 = new Femme("Lee", "Olivia", "8888888888", "654 Birch St", new Date("1987/06/30"));
        Femme f8 = new Femme("Wilson", "Ava", "9999999999", "890 Maple St", new Date("1992/01/17"));
        Femme f9 = new Femme("Rodriguez", "Mia", "4444444444", "432 Fir St", new Date("1976/05/05"));

        Homme h1 = new Homme("Doe", "John", "0568899888", "Rue de Paris", new Date("1970/03/15"));
        Homme h2 = new Homme("Smith", "Michael", "1231231234", "Rue de Londres", new Date("1982/08/25"));
        Homme h3 = new Homme("Johnson", "William", "9876543210", "Rue de Berlin", new Date("1995/12/12"));
        Homme h4 = new Homme("Brown", "James", "5555555555", "Rue de Madrid", new Date("1989/04/20"));
        Homme h5 = new Homme("Garcia", "David", "7777777777", "Rue de Rome", new Date("1980/11/28"));

        fs.create(f1);
        fs.create(f2);
        fs.create(f3);
        fs.create(f4);
        fs.create(f5);
        fs.create(f6);
        fs.create(f7);
        fs.create(f8);
        fs.create(f9);

////////////////////////////////77777
        HommeService hs = new HommeService();
        hs.create(h1);
        hs.create(h2);
        hs.create(h3);
        hs.create(h4);
        hs.create(h5);

        MariageService ms = new MariageService();

        MariagePK mpkey1 = new MariagePK(1, 12, new Date("2023/06/07"));
        MariagePK mpkey2 = new MariagePK(5, 13, new Date("2020/06/07"));
        MariagePK mpkey3 = new MariagePK(6, 14, new Date("2023/03/09"));
        MariagePK mpkey4 = new MariagePK(3, 11, new Date("2016/02/07"));
        MariagePK mpkey5 = new MariagePK(4, 11, new Date("2022/05/07"));
        MariagePK mpkey6 = new MariagePK(7, 11, new Date("2018/06/07"));
        MariagePK mpkey7 = new MariagePK(9, 11, new Date("2014/06/07"));

        Mariage m1 = new Mariage(mpkey1, null, 3);
        Mariage m2 = new Mariage(mpkey2, new Date("2023/06/11"), 2);
        Mariage m3 = new Mariage(mpkey3, null, 3);
        Mariage m4 = new Mariage(mpkey4, new Date("2019/08/12"), 1);
        Mariage m5 = new Mariage(mpkey5, new Date("2023/01/01"), 3);
        Mariage m6 = new Mariage(mpkey6, new Date("2020/06/01"), 3);
        Mariage m7 = new Mariage(mpkey3, null, 3);

        ms.create(m1);
        ms.create(m2);
        ms.create(m3);
        ms.create(m4);
        ms.create(m5);
        ms.create(m6);
        ms.create(m7);

        for (Femme ff : fs.getAll()) {
            System.out.println(ff);
        }
        System.out.println(fs.getFemmeLaPlusAgee().getNom());

        hs.getEpousesParHomme(hs.getById(13));
        for (Femme fem : fs.getFemmesMarieesDeuxFoisOuPlus()) {
            System.out.println(fem);
        }

        hs.getHommesMariesParQuatreFemmesEntreDates(new Date("2000/01/01"), new Date("2024/01/01"));

        for (Mariage m : hs.getMariagesByHomme(hs.getById(11))) {
            System.out.println(m);
        }
    }
}

