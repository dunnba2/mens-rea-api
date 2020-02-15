package com.revature;

import com.revature.models.Role;
import com.revature.models.mediatypes.Book;
import com.revature.models.mediatypes.Movie;
import com.revature.models.mediatypes.TvShow;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

public class TestDriver {

    public static void main(String[] args) {

//        addRole();
//        addMedia();

    }

    public static void addRole() {

        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {

            session.beginTransaction();
            Role role1 = new Role("ADMIN");
            Role role2 = new Role("MEMBER");

            session.save(role1);
            session.save(role2);

            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addMedia() {

        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {

            session.beginTransaction();

//            Movie m1 = new Movie("Who Framed Roger Rabbit?", "Robert Zemeckis", "1988", "PG", 0);
//            Movie m2 = new Movie("Crooked House", "Giles Paquet-Brenner", "2017", "PG-13", 0);
//            Movie m3 = new Movie("Murder on the Orient Express", "Kenneth Branagh", "2017", "PG-13", 0);
//            Movie m4 = new Movie("Murder Mystery", "Kyle Newacheck", "2019", "PG-13", 0);
//            Movie m5 = new Movie("Knives Out", "Rian Johnson", "2019", "PG-13", 0);
//            Movie m6 = new Movie("Coco", "Lee Unkrich, Adrian Molina", "2017", "PG", 0);
//            Movie m7 = new Movie("Basic Instinct", "Paul Verhoeven", "1992", "R", 0);
//            Movie m8 = new Movie("Dick Tracy", "Warren Beatty", "1990", "PG", 0);
//            Movie m9 = new Movie("Game Night", "John Francis Daley, Jonathan Goldstein", "2018", "R", 0);
//            Movie m10 = new Movie("Eagle Eye", "D.J. Caruso", "2008", "PG-13", 0);
//            Movie m11 = new Movie("Perfect Stranger", "James Foley", "2007", "R", 0);
//            Movie m12 = new Movie("Minority Report", "Steven Spielberg", "2002", "PG-13", 0);
//            Movie m13 = new Movie("Psycho", "Alfred Hitchcock", "1960", "R", 0);
//
//
//            session.save(m1);
//            session.save(m2);
//            session.save(m3);
//            session.save(m4);
//            session.save(m5);
//            session.save(m6);
//            session.save(m7);
//            session.save(m8);
//            session.save(m9);
//            session.save(m10);
//            session.save(m11);
//            session.save(m12);
//            session.save(m13);

            TvShow a=new TvShow("Numb3rs", "Nicolas Falacci, Cheryl Heuton", "2005", "TV-PG", 0);
            TvShow b=new TvShow("Sherlock", "Mark Gatiss, Steven Moffat", "2010", "TV-14", 0);
            Movie c=new Movie("Sherlock: A Case of Evil","Graham Theakston","2002","R",0);
            TvShow d=new TvShow("Elementary","Robert Doherty","2012","TV-14",0);
            Movie e=new Movie("Sherlock Holmes","Guy Ritchie","2009","PG-13",0);
            Movie f=new Movie("Sherlock Holmes: A Game of Shadows","Guy Ritchie","2011","PG-13",0);
            TvShow g=new TvShow("CSI: Miami","Ann Donahue, Carol Mendelsohn, Anthony E. Zuiker","2002","TV-14",0);
            TvShow h=new TvShow("CSI: Crime Scene Investigation","Anthony E. Zuiker","2000","TV-14",0);
            TvShow i=new TvShow("CSI: NY","Ann Donahue, Carol Mendelsohn, Anthony E. Zuiker","2004","TV-14",0);
            TvShow j=new TvShow("CSI:Cyber","Ann Donahue, Carol Mendelsohn, Anthony E. Zuiker","2015","TV-14",0);
            Movie k=new Movie("CSI: Immortality","Louis Shaw Milito","2015","TV-14",0);
            TvShow l=new TvShow("Law & Order","Dick Wolf","1990","TV-14",0);
            TvShow m=new TvShow("Law & Order: LA","Blake Masters, Dick Wolf","2010","TV-14",0);
            TvShow n=new TvShow("Law & Order: Special Victims Unit","Dick Wolf","1999","TV-14",0);
            TvShow o=new TvShow("Law & Order: Criminal Intent","Rene Balcer, Dick Wolf","2001","TV-14",0);
            TvShow p=new TvShow("Law & Order: UK","Dick Wolf","2009","TV-14",0);
            TvShow q=new TvShow("Burn Notice","Matt Nix","2007","TV-PG",0);
            TvShow r=new TvShow("Midsomer Murders","Caroline Graham","1997","TV-14",0);
            TvShow s=new TvShow("True Detective","Nic Pizzolatto","2014","TV-MA",0);
            TvShow t=new TvShow("Criminal Minds","Jeff Davis","2005","TV-14",0);
            TvShow u=new TvShow("Riverdale","Roberto Aguirre-Sacasa","2017","TV-14",0);
            TvShow v=new TvShow("Murdoch Mysteries","Maureen Jennings, Cal Coons, Alexandra Zarowny","2008","TV-PG",0);
            TvShow w=new TvShow("Murder, She Wrote","Peter S. Fischer, Richard Levinson, William Link","1984","TV-PG",0);
            TvShow y=new TvShow("NCIS","Donald P. Bellisario, Don McGill","2003","TV-14",0);
            Book z=new Book("The Woman in White","Wilkie Collins","1859","Book",0);
            Book aa=new Book("The Moonstone","Wilkie Collins","1868","Book",0);
            Book ab=new Book("Murder on the Orient Express","Agatha Christie","1934","Book",0);
            Book ac=new Book("Rebecca","Daphne du Maurier","1938","Book",0);
            Book ad=new Book("The Big Sleep","Raymond Chandler","1939","Book",0);
            Book ae=new Book("The Girl with the Dragon Tattoo","Stieg Larsson","2005","Book",0);
            Book af=new Book("The Daughter of Time","Josephine Tey","1951","Book",0);
            Book ag=new Book("The Maltese Falcon","Dashiell Hammett","1930","Book",0);
            Book ah=new Book("A is for Alibi","Sue Grafton","1982","Book",0);
            Book ai=new Book("B is for Burglar","Sue Grafton","1985","Book",0);
            Book aj=new Book("C is for Corpse","Sue Grafton","1986","Book",0);
            Book ak=new Book("D is for Deadbeat","Sue Grafton","1987","Book",0);
            Book al=new Book("E is for Evidence","Sue Grafton","1988","Book",0);
            Book am=new Book("F is for Fugitive","Sue Grafton","1989","Book",0);
            Book an=new Book("G is for Gumshoe","Sue Grafton","1990","Book",0);
            Book ao=new Book("H is for Homicide","Sue Grafton","1991","Book",0);
            Book ap=new Book("I is for Innocent","Sue Grafton","1992","Book",0);
            Book aq=new Book("J is for Judgment","Sue Grafton","1993","Book",0);
            Book ar=new Book("K is for Killer","Sue Grafton","1994","Book",0);
            Book as=new Book("L is for Lawless","Sue Grafton","1995","Book",0);
            Book at=new Book("M is for Malice","Sue Grafton","1996","Book",0);
            Book au=new Book("N is for Noose","Sue Grafton","1998","Book",0);
            Book av=new Book("O is for Outlaw","Sue Grafton","1999","Book",0);
            Book aw=new Book("P is for Peril","Sue Grafton","2001","Book",0);
            Book ax=new Book("Q is for Quarry","Sue Grafton","2002","Book",0);
            Book ay=new Book("R is for Ricochet","Sue Grafton","2004","Book",0);
            Book az=new Book("S is for Silence","Sue Grafton","2005","Book",0);
            Book ba=new Book("T is for Trespass","Sue Grafton","2007","Book",0);
            Book bb=new Book("U is for Undertow","Sue Grafton","2009","Book",0);
            Book bc=new Book("V is for Vengeance","Sue Grafton","2011","Book",0);
            Book bd=new Book("W is for Wasted","Sue Grafton","2013","Book",0);
            Book be=new Book("X","Sue Grafton","2015","Book",0);
            Book bf=new Book("Y is for Yesterday","Sue Grafton","2017","Book",0);
            Book bg=new Book("A Study in Scarlet","Sir Arthur Conan Doyle","1887","Book",0);
            Book bh=new Book("The Sign of the Four","Sir Arthur Conan Doyle","1890","Book",0);
            Book bi=new Book("The Hound of the Baskervilles","Sir Arthur Conan Doyle","1902","Book",0);
            Book bj=new Book("The Valley of Fear","Sir Arthur Conan Doyle","1915","Book",0);

            session.save(a);
            session.save(b);
            session.save(c);
            session.save(d);
            session.save(e);
            session.save(f);
            session.save(g);
            session.save(h);
            session.save(i);
            session.save(j);
            session.save(k);
            session.save(l);
            session.save(m);
            session.save(n);
            session.save(o);
            session.save(p);
            session.save(q);
            session.save(r);
            session.save(s);
            session.save(t);
            session.save(u);
            session.save(v);
            session.save(w);
            session.save(y);
            session.save(z);
            session.save(aa);
            session.save(ab);
            session.save(ac);
            session.save(ad);
            session.save(ae);
            session.save(af);
            session.save(ag);
            session.save(ah);
            session.save(ai);
            session.save(aj);
            session.save(ak);
            session.save(al);
            session.save(am);
            session.save(an);
            session.save(ao);
            session.save(ap);
            session.save(aq);
            session.save(ar);
            session.save(as);
            session.save(at);
            session.save(au);
            session.save(av);
            session.save(aw);
            session.save(ax);
            session.save(ay);
            session.save(az);
            session.save(ba);
            session.save(bb);
            session.save(bc);
            session.save(bd);
            session.save(be);
            session.save(bf);
            session.save(bg);
            session.save(bh);
            session.save(bi);
            session.save(bj);




            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addFavorite() {

    }
}
