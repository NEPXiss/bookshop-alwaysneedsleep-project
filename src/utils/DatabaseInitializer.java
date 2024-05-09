package utils;

import item.Book;
import store.StoreStorage;
import usage.ItemGenre;

public class DatabaseInitializer {
    public static void initializeDataBase(){
        ////add example book database
        Book book1 = new Book("Siddhartha", "Herman Hesse", ItemGenre.FICTION, 550, 4, 50, "L4", "books/siddhartha.jpg",
                "Told in a simple mythical style, the story of Siddhartha is an inspirational classic by Hermann Hesse, winner of the Nobel Prize for Literature. Integrating Eastern and Western spiritual traditions with psychoanalysis and philosophy, this title tells the story of a young Brahmin's search for ultimate reality after meeting with the Buddha.");
        StoreStorage.getStorage().getShelfMap().put(book1,book1.getItemLocation());

        Book book2 = new Book("Crime and Punishment", "Fyodor Dostoevsky", ItemGenre.FICTION, 600, 5, 50, "L4", "books/crimeandpunishment.jpg" ,
                "Dostoyevsky's great novel of damnation and redemption evokes a world where the lines between innocence and corruption, good and evil, blur. It tells the story of Raskolnikov, a destitute and desperate former student, who wanders through the slums of St Petersburg and commits a random murder without remorse or regret. He imagines himself to be beyond conventional moral laws. But as he embarks on a dangerous game of cat and mouse with a police investigator, Raskolnikov is pursued by the growing voice of his conscience and finds the noose of his own guilt tightening around his neck.");
        StoreStorage.getStorage().getShelfMap().put(book2,book2.getItemLocation());

        Book book3 = new Book("Les Miserables", "Victor Hugo", ItemGenre.FICTION, 750, 4, 50, "L4", "books/lesmiserable.jpg",
                "Introducing one of the most famous characters in literature, Jean Valjean—the noble peasant imprisoned for stealing a loaf of bread—Les Misérables ranks among the greatest novels of all time. In it, Victor Hugo takes readers deep into the Parisian underworld, immerses them in a battle between good and evil, and carries them to the barricades during the uprising of 1832 with a breathtaking realism that is unsurpassed in modern prose. Within his dramatic story are themes that capture the intellect and the emotions: crime and punishment, the relentless persecution of Valjean by Inspector Javert, the desperation of the prostitute Fantine, the amorality of the rogue Thénardier, and the universal desire to escape the prisons of our own minds. Les Misérables gave Victor Hugo a canvas upon which he portrayed his criticism of the French political and judicial systems, but the portrait that resulted is larger than life, epic in scope—an extravagant spectacle that dazzles the senses even as it touches the heart.");
        StoreStorage.getStorage().getShelfMap().put(book3,book3.getItemLocation());

        Book book4 = new Book("The Stranger", "Albert Camus", ItemGenre.FICTION, 250, 5, 50, "L4", "books/thestranger.jpg" ,
                "A visually stunning adaptation of Albert Camus’ masterpiece that offers an exciting new graphic interpretation while retaining the book’s unique atmosphere. This new illustrated edition of Camus's classic novel The Stranger portrays an enigmatic man who commits a senseless crime and then calmly, and apparently indifferently, sits through his trial and hears himself condemned to death.");
        StoreStorage.getStorage().getShelfMap().put(book4,book4.getItemLocation());

        Book book5 = new Book("American Prometheus", "Kai Bird & Martin J. Sherwin", ItemGenre.HISTORY, 400, 4, 50, "H1", "books/americanprometheus.jpg",
                "#1 NEW YORK TIMES BESTSELLER • PULITZER PRIZE WINNER • The definitive biography of J. Robert Oppenheimer, one of the iconic figures of the twentieth century, a brilliant physicist who led the effort to build the atomic bomb for his country in a time of war, and who later found himself confronting the moral consequences of scientific progress.");
        StoreStorage.getStorage().getShelfMap().put(book5,book5.getItemLocation());

        Book book6 = new Book("A Brief History of Time", "Stephen Hawking", ItemGenre.SCIENCE, 350, 5, 100, "S5", "books/abriefhistoryoftime.jpg",
                "Was there a beginning of time? Could time run backwards? Is the universe infinite or does it have boundaries? These are just some of the questions considered in an internationally acclaimed masterpiece by one of the world's greatest thinkers. It begins by reviewing the great theories of the cosmos from Newton to Einstein, before delving into the secrets which still lie at the heart of space and time, from the Big Bang to black holes, via spiral galaxies and strong theory. To this day \"A Brief History of Time\" remains a staple of the scientific canon, and its succinct and clear language continues to introduce millions to the universe and its wonders.");
        StoreStorage.getStorage().getShelfMap().put(book6,book6.getItemLocation());

        Book book7 = new Book("Meditation", "Marcus Aurelius", ItemGenre.PHILOSOPHY, 270, 5, 50, "PH2", "books/meditation.jpg",
                "Written in Greek by the only Roman emperor who was also a philosopher, without any intention of publication, the Meditations of Marcus Aurelius offer a remarkable series of challenging spiritual reflections and exercises developed as the emperor struggled to understand himself and make sense of the universe. While the Meditations were composed to provide personal consolation and encouragement, Marcus Aurelius also created one of the greatest of all works of philosophy: a timeless collection that has been consulted and admired by statesmen, thinkers and readers throughout the centuries.");
        StoreStorage.getStorage().getShelfMap().put(book7,book7.getItemLocation());

        Book book8 = new Book("Road To Wigan Pier", "George Orwell", ItemGenre.HISTORY, 370, 5, 50, "H2", "books/roadtowiganpier.jpg",
                "In the 1930s, commissioned by a left-wing book club, Orwell went to the industrial areas of northern England to investigate and record the real situation of the working class. Orwell did more than just investigate; he went down to the deepest part of the mine, lived in dilapidated and filthy workers' houses, and used the tip of his pen to vividly reveal every aspect of the coal miners' lives. Reading today, 80 years later, Still shockingly true. The despair and poverty conveyed by this picture have a terrifying power that transcends time and national boundaries. At the same time, the Road to Wigan Pier is also Orwell's road to socialism as he examines his own inner self. Born in the British middle class, he recalled how he gradually began to doubt and then hate the strict class barriers that divided British society at that time. Because in his mind, socialism ultimately means only one concept: \"justice and freedom.\"");
        StoreStorage.getStorage().getShelfMap().put(book8,book8.getItemLocation());

        Book book9 = new Book("Letters Of J.R.R Tolkien", "J.R.R Tolkien", ItemGenre.PHILOSOPHY, 470, 5, 50, "H2", "books/letteroftolkien.jpg",
                "J.R.R. Tolkien was one of the most prolific letter writers of this century. Over the years he wrote to his publishers, his family, to friends (including C.S. Lewis, W.H. Auden and Naomi Mitchison) and to fans of his books. The letters present a fascinating and highly detailed portrait of the man in many of his aspects: as storyteller, scholar, Catholic, parent and observer of the world around him. They also shed much light on his creative genius and grand design for the creation of a whole new world – Middle-earth.\n\n" +"This collection will appeal not only to the legions of Tolkien fans, but will entertain anyone who appreciates the art of letter-writing, of which Tolkien was a master.");
        StoreStorage.getStorage().getShelfMap().put(book9,book9.getItemLocation());

        Book book10 = new Book("Faust", "J W Goethe", ItemGenre.FICTION, 170, 4, 20, "L1", "books/faust.jpg",
                "Translated, with an Introduction and Notes by John R. Williams. Goethe's 'Faust' is a classic of European literature. Based on the fable of the man who traded his soul for superhuman powers and knowledge, it became the life's work of Germany's greatest poet. Beginning with an intriguing wager between God and Satan, it charts the life of a deeply flawed individual, his struggle against the nihilism of his diabolical companion Mephistopheles. Part One presents Faust's pact with the Devil and the harrowing tragedy of his love affair with the young Gretchen. Part Two shows Faust's experience in the world of public affairs, including his encounter with Helen of Troy, the emblem of classical beauty and culture. The whole is a symbolic and panoramic commentary on the human condition and on modern European history and civilisation. ");
        StoreStorage.getStorage().getShelfMap().put(book10,book10.getItemLocation());

        Book book11 = new Book("Walden", "Henry D. Thoreau", ItemGenre.PHILOSOPHY, 270, 5, 50, "PH1", "books/walden.jpg",
                "Originally published in 1854, Walden; or, Life in the Woods, is a vivid account of the time that Henry D. Thoreau lived alone in a secluded cabin at Walden Pond. It is one of the most influential and compelling books in American literature. This new paperback edition-introduced by noted American writer John Updike-celebrates the 150th anniversary of this classic work. Much of Walden's material is derived from Thoreau's journals and contains such engaging pieces as \"Reading\" and \"The Pond in the Winter\" Other famous sections involve Thoreau's visits with a Canadian woodcutter and with an Irish family, a trip to Concord, and a description of his bean field.");
        StoreStorage.getStorage().getShelfMap().put(book11,book11.getItemLocation());

        Book book12 = new Book("East Of Eden", "John Steinbeck", ItemGenre.FICTION, 640, 5, 50, "L2", "books/eastofeden.jpg",
                "The masterpiece of Steinbeck’s later years, East of Eden is a work in which Steinbeck created his most mesmerizing characters and explored his most enduring themes: the mystery of identity, the inexplicability of love, and the murderous consequences of love’s absence. Adapted for the 1955 film directed by Elia Kazan introducing James Dean and read by thousands as the book that brought Oprah’s Book Club back, East of Eden has remained vitally present in American culture for over half a century.");
        StoreStorage.getStorage().getShelfMap().put(book12,book12.getItemLocation());

        Book book13 = new Book("The Brothers Karamazov", "Fyodor Dostoevsky", ItemGenre.FICTION, 870, 5, 50, "PH2", "books/brotherkaramazov.jpg",
                "The Brothers Karamasov is a murder mystery, a courtroom drama, and an exploration of erotic rivalry in a series of triangular love affairs involving the “wicked and sentimental” Fyodor Pavlovich Karamazov and his three sons―the impulsive and sensual Dmitri; the coldly rational Ivan; and the healthy, red-cheeked young novice Alyosha. Through the gripping events of their story, Dostoevsky portrays the whole of Russian life, is social and spiritual striving, in what was both the golden age and a tragic turning point in Russian culture.");
        StoreStorage.getStorage().getShelfMap().put(book13,book13.getItemLocation());

        Book book14 = new Book("Outlier", "Malcom Gladwell", ItemGenre.PSYCHOLOGY, 550, 5, 2, "PH2", "books/outlier.jpg",
                "From the bestselling author of Blink and The Tipping Point, Malcolm Gladwell's Outliers: The Story of Success overturns conventional wisdom about genius to show us what makes an ordinary person an extreme overachiever.");
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
