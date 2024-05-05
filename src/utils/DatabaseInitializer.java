package utils;

import item.Book;
import store.StoreStorage;
import usage.ItemGenre;

public class DatabaseInitializer {
    public static void initializeDataBase(){
        ////add example book database
        Book book1 = new Book("Siddhartha", "Herman Hesse", ItemGenre.FICTION, 550, 4, 50, "L4", "books/siddhartha.jpg" );
        StoreStorage.getStorage().getShelfMap().put(book1,book1.getItemLocation());
        Book book2 = new Book("Crime and Punishment", "Fyodor Dostoevsky", ItemGenre.FICTION, 600, 5, 50, "L4", "books/crimeandpunishment.jpg" );
        StoreStorage.getStorage().getShelfMap().put(book2,book2.getItemLocation());
        Book book3 = new Book("Les Miserables", "Victor Hugo", ItemGenre.FICTION, 750, 4, 50, "L4", "books/lesmiserable.jpg" );
        StoreStorage.getStorage().getShelfMap().put(book3,book3.getItemLocation());
        Book book4 = new Book("The Stranger", "Albert Camus", ItemGenre.FICTION, 250, 5, 50, "L4", "books/thestranger.jpg" );
        StoreStorage.getStorage().getShelfMap().put(book4,book4.getItemLocation());
        Book book5 = new Book("American Prometheus", "Kai Bird & Martin J. Sherwin", ItemGenre.HISTORY, 400, 4, 50, "H1", "books/americanprometheus.jpg" );
        StoreStorage.getStorage().getShelfMap().put(book5,book5.getItemLocation());
        Book book6 = new Book("A Brief History of Time", "Stephen Hawking", ItemGenre.SCIENCE, 350, 5, 100, "S5", "books/abriefhistoryoftime.jpg" );
        StoreStorage.getStorage().getShelfMap().put(book6,book6.getItemLocation());
        Book book7 = new Book("Meditation", "Marcus Aurelius", ItemGenre.PHILOSOPHY, 270, 5, 50, "PH2", "books/meditation.jpg" );
        StoreStorage.getStorage().getShelfMap().put(book7,book7.getItemLocation());
        Book book8 = new Book("Road To Wigan Pier", "George Orwell", ItemGenre.HISTORY, 370, 5, 50, "H2", "books/roadtowiganpier.jpg" );
        StoreStorage.getStorage().getShelfMap().put(book8,book8.getItemLocation());
        Book book9 = new Book("Letters Of J.R.R Tolkien", "J.R.R Tolkien", ItemGenre.PHILOSOPHY, 470, 5, 50, "H2", "books/letteroftolkien.jpg" );
        StoreStorage.getStorage().getShelfMap().put(book9,book9.getItemLocation());
        Book book10 = new Book("Faust", "J W Goethe", ItemGenre.FICTION, 170, 4, 20, "L1", "books/faust.jpg" );
        StoreStorage.getStorage().getShelfMap().put(book10,book10.getItemLocation());
        Book book11 = new Book("Walden", "Henry D. Thoreau", ItemGenre.PHILOSOPHY, 270, 5, 50, "PH1", "books/walden.jpg" );
        StoreStorage.getStorage().getShelfMap().put(book11,book11.getItemLocation());
        Book book12 = new Book("East Of Eden", "John Steinbeck", ItemGenre.FICTION, 640, 5, 50, "L2", "books/eastofeden.jpg" );
        StoreStorage.getStorage().getShelfMap().put(book12,book12.getItemLocation());
        Book book13 = new Book("The Brothers Karamazov", "Fyodor Dostoevsky", ItemGenre.FICTION, 870, 5, 50, "PH2", "books/brotherkaramazov.jpg" );
        StoreStorage.getStorage().getShelfMap().put(book13,book13.getItemLocation());
        Book book14 = new Book("Outlier", "Malcom Gladwell", ItemGenre.PSYCHOLOGY, 550, 5, 50, "PH2", "books/outlier.jpg" );
        StoreStorage.getStorage().getShelfMap().put(book14,book14.getItemLocation());


        ///add example books to newArrivalList
        StoreStorage.getStorage().getNewArrivalList().add(book1);
        StoreStorage.getStorage().getNewArrivalList().add(book3);
        StoreStorage.getStorage().getNewArrivalList().add(book5);

        ///add example books to recommendedItemsList
        StoreStorage.getStorage().getRecommendedItemsList().add(book1);
        StoreStorage.getStorage().getRecommendedItemsList().add(book2);
        StoreStorage.getStorage().getRecommendedItemsList().add(book3);
        StoreStorage.getStorage().getRecommendedItemsList().add(book4);
        StoreStorage.getStorage().getRecommendedItemsList().add(book5);
        StoreStorage.getStorage().getRecommendedItemsList().add(book6);
        StoreStorage.getStorage().getRecommendedItemsList().add(book7);
        StoreStorage.getStorage().getRecommendedItemsList().add(book8);
        StoreStorage.getStorage().getRecommendedItemsList().add(book9);
        StoreStorage.getStorage().getRecommendedItemsList().add(book10);
        StoreStorage.getStorage().getRecommendedItemsList().add(book11);
        StoreStorage.getStorage().getRecommendedItemsList().add(book12);
        StoreStorage.getStorage().getRecommendedItemsList().add(book13);
        StoreStorage.getStorage().getRecommendedItemsList().add(book14);

    }
}
