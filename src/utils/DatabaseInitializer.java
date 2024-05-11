package utils;

import item.Book;
import store.StoreStorage;
import usage.ItemGenre;

public class DatabaseInitializer {
    public static void initializeDataBase(){
        ////add example book database
        Book book1 = new Book("Siddhartha", "Herman Hesse", ItemGenre.FICTION, 550, 4, 25, "L4", "books/siddhartha.jpg",
                "Told in a simple mythical style, the story of Siddhartha is an inspirational classic by Hermann Hesse, winner of the Nobel Prize for Literature. Integrating Eastern and Western spiritual traditions with psychoanalysis and philosophy, this title tells the story of a young Brahmin's search for ultimate reality after meeting with the Buddha.");
        StoreStorage.getStorage().getShelfMap().put(book1,book1.getItemLocation());

        Book book2 = new Book("Crime and Punishment", "Fyodor Dostoevsky", ItemGenre.FICTION, 600, 5, 10, "L4", "books/crimeandpunishment.jpg" ,
                "Dostoyevsky's great novel of damnation and redemption evokes a world where the lines between innocence and corruption, good and evil, blur. It tells the story of Raskolnikov, a destitute and desperate former student, who wanders through the slums of St Petersburg and commits a random murder without remorse or regret. He imagines himself to be beyond conventional moral laws. But as he embarks on a dangerous game of cat and mouse with a police investigator, Raskolnikov is pursued by the growing voice of his conscience and finds the noose of his own guilt tightening around his neck.");
        StoreStorage.getStorage().getShelfMap().put(book2,book2.getItemLocation());

        Book book3 = new Book("Les Miserables", "Victor Hugo", ItemGenre.FICTION, 750, 4, 60, "L4", "books/lesmiserable.jpg",
                "Introducing one of the most famous characters in literature, Jean Valjean—the noble peasant imprisoned for stealing a loaf of bread—Les Misérables ranks among the greatest novels of all time. In it, Victor Hugo takes readers deep into the Parisian underworld, immerses them in a battle between good and evil, and carries them to the barricades during the uprising of 1832 with a breathtaking realism that is unsurpassed in modern prose. Within his dramatic story are themes that capture the intellect and the emotions: crime and punishment, the relentless persecution of Valjean by Inspector Javert, the desperation of the prostitute Fantine, the amorality of the rogue Thénardier, and the universal desire to escape the prisons of our own minds. Les Misérables gave Victor Hugo a canvas upon which he portrayed his criticism of the French political and judicial systems, but the portrait that resulted is larger than life, epic in scope—an extravagant spectacle that dazzles the senses even as it touches the heart.");
        StoreStorage.getStorage().getShelfMap().put(book3,book3.getItemLocation());

        Book book4 = new Book("The Stranger", "Albert Camus", ItemGenre.FICTION, 250, 5, 40, "L4", "books/thestranger.jpg" ,
                "A visually stunning adaptation of Albert Camus’ masterpiece that offers an exciting new graphic interpretation while retaining the book’s unique atmosphere. This new illustrated edition of Camus's classic novel The Stranger portrays an enigmatic man who commits a senseless crime and then calmly, and apparently indifferently, sits through his trial and hears himself condemned to death.");
        StoreStorage.getStorage().getShelfMap().put(book4,book4.getItemLocation());

        Book book5 = new Book("American Prometheus", "Kai Bird & Martin J. Sherwin", ItemGenre.HISTORY, 400, 4, 55, "H1", "books/americanprometheus.jpg",
                "#1 NEW YORK TIMES BESTSELLER • PULITZER PRIZE WINNER • The definitive biography of J. Robert Oppenheimer, one of the iconic figures of the twentieth century, a brilliant physicist who led the effort to build the atomic bomb for his country in a time of war, and who later found himself confronting the moral consequences of scientific progress.");
        StoreStorage.getStorage().getShelfMap().put(book5,book5.getItemLocation());

        Book book6 = new Book("A Brief History of Time", "Stephen Hawking", ItemGenre.SCIENCE, 350, 5, 100, "S5", "books/abriefhistoryoftime.jpg",
                "Was there a beginning of time? Could time run backwards? Is the universe infinite or does it have boundaries? These are just some of the questions considered in an internationally acclaimed masterpiece by one of the world's greatest thinkers. It begins by reviewing the great theories of the cosmos from Newton to Einstein, before delving into the secrets which still lie at the heart of space and time, from the Big Bang to black holes, via spiral galaxies and strong theory. To this day \"A Brief History of Time\" remains a staple of the scientific canon, and its succinct and clear language continues to introduce millions to the universe and its wonders.");
        StoreStorage.getStorage().getShelfMap().put(book6,book6.getItemLocation());

        Book book7 = new Book("Meditation", "Marcus Aurelius", ItemGenre.PHILOSOPHY, 270, 5, 36, "PH2", "books/meditation.jpg",
                "Written in Greek by the only Roman emperor who was also a philosopher, without any intention of publication, the Meditations of Marcus Aurelius offer a remarkable series of challenging spiritual reflections and exercises developed as the emperor struggled to understand himself and make sense of the universe. While the Meditations were composed to provide personal consolation and encouragement, Marcus Aurelius also created one of the greatest of all works of philosophy: a timeless collection that has been consulted and admired by statesmen, thinkers and readers throughout the centuries.");
        StoreStorage.getStorage().getShelfMap().put(book7,book7.getItemLocation());

        Book book8 = new Book("Road To Wigan Pier", "George Orwell", ItemGenre.HISTORY, 370, 5, 25, "H2", "books/roadtowiganpier.jpg",
                "In the 1930s, commissioned by a left-wing book club, Orwell went to the industrial areas of northern England to investigate and record the real situation of the working class. Orwell did more than just investigate; he went down to the deepest part of the mine, lived in dilapidated and filthy workers' houses, and used the tip of his pen to vividly reveal every aspect of the coal miners' lives. Reading today, 80 years later, Still shockingly true. The despair and poverty conveyed by this picture have a terrifying power that transcends time and national boundaries. At the same time, the Road to Wigan Pier is also Orwell's road to socialism as he examines his own inner self. Born in the British middle class, he recalled how he gradually began to doubt and then hate the strict class barriers that divided British society at that time. Because in his mind, socialism ultimately means only one concept: \"justice and freedom.\"");
        StoreStorage.getStorage().getShelfMap().put(book8,book8.getItemLocation());

        Book book9 = new Book("Letters Of J.R.R. Tolkien", "J.R.R. Tolkien", ItemGenre.PHILOSOPHY, 470, 5, 42, "H2", "books/letteroftolkien.jpg",
                "J.R.R. Tolkien was one of the most prolific letter writers of this century. Over the years he wrote to his publishers, his family, to friends (including C.S. Lewis, W.H. Auden and Naomi Mitchison) and to fans of his books. The letters present a fascinating and highly detailed portrait of the man in many of his aspects: as storyteller, scholar, Catholic, parent and observer of the world around him. They also shed much light on his creative genius and grand design for the creation of a whole new world – Middle-earth.\n\n" +"This collection will appeal not only to the legions of Tolkien fans, but will entertain anyone who appreciates the art of letter-writing, of which Tolkien was a master.");
        StoreStorage.getStorage().getShelfMap().put(book9,book9.getItemLocation());

        Book book10 = new Book("Faust", "J W Goethe", ItemGenre.FICTION, 170, 4, 20, "L1", "books/faust.jpg",
                "Translated, with an Introduction and Notes by John R. Williams. Goethe's 'Faust' is a classic of European literature. Based on the fable of the man who traded his soul for superhuman powers and knowledge, it became the life's work of Germany's greatest poet. Beginning with an intriguing wager between God and Satan, it charts the life of a deeply flawed individual, his struggle against the nihilism of his diabolical companion Mephistopheles. Part One presents Faust's pact with the Devil and the harrowing tragedy of his love affair with the young Gretchen. Part Two shows Faust's experience in the world of public affairs, including his encounter with Helen of Troy, the emblem of classical beauty and culture. The whole is a symbolic and panoramic commentary on the human condition and on modern European history and civilisation. ");
        StoreStorage.getStorage().getShelfMap().put(book10,book10.getItemLocation());

        Book book11 = new Book("Walden", "Henry D. Thoreau", ItemGenre.PHILOSOPHY, 270, 5, 12, "PH1", "books/walden.jpg",
                "Originally published in 1854, Walden; or, Life in the Woods, is a vivid account of the time that Henry D. Thoreau lived alone in a secluded cabin at Walden Pond. It is one of the most influential and compelling books in American literature. This new paperback edition-introduced by noted American writer John Updike-celebrates the 150th anniversary of this classic work. Much of Walden's material is derived from Thoreau's journals and contains such engaging pieces as \"Reading\" and \"The Pond in the Winter\" Other famous sections involve Thoreau's visits with a Canadian woodcutter and with an Irish family, a trip to Concord, and a description of his bean field.");
        StoreStorage.getStorage().getShelfMap().put(book11,book11.getItemLocation());

        Book book12 = new Book("East Of Eden", "John Steinbeck", ItemGenre.FICTION, 640, 5, 30, "L2", "books/eastofeden.jpg",
                "The masterpiece of Steinbeck’s later years, East of Eden is a work in which Steinbeck created his most mesmerizing characters and explored his most enduring themes: the mystery of identity, the inexplicability of love, and the murderous consequences of love’s absence. Adapted for the 1955 film directed by Elia Kazan introducing James Dean and read by thousands as the book that brought Oprah’s Book Club back, East of Eden has remained vitally present in American culture for over half a century.");
        StoreStorage.getStorage().getShelfMap().put(book12,book12.getItemLocation());

        Book book13 = new Book("The Brothers Karamazov", "Fyodor Dostoevsky", ItemGenre.FICTION, 870, 5, 11, "PH2", "books/brotherkaramazov.jpg",
                "The Brothers Karamasov is a murder mystery, a courtroom drama, and an exploration of erotic rivalry in a series of triangular love affairs involving the “wicked and sentimental” Fyodor Pavlovich Karamazov and his three sons―the impulsive and sensual Dmitri; the coldly rational Ivan; and the healthy, red-cheeked young novice Alyosha. Through the gripping events of their story, Dostoevsky portrays the whole of Russian life, is social and spiritual striving, in what was both the golden age and a tragic turning point in Russian culture.");
        StoreStorage.getStorage().getShelfMap().put(book13,book13.getItemLocation());

        Book book14 = new Book("Outlier", "Malcom Gladwell", ItemGenre.PSYCHOLOGY, 550, 5, 2, "PS2", "books/outlier.jpg",
                "From the bestselling author of Blink and The Tipping Point, Malcolm Gladwell's Outliers: The Story of Success overturns conventional wisdom about genius to show us what makes an ordinary person an extreme overachiever.");
        StoreStorage.getStorage().getShelfMap().put(book14,book14.getItemLocation());

        Book book15 = new Book("Being and Nothingness", "Jean-Paul Sartre", ItemGenre.PHILOSOPHY, 760, 4, 63, "PH2", "books/beingandnothingness.jpg",
                "Revisit one of the most important pillars in modern philosophy with this new English translation—the first in more than 60 years—of Jean-Paul Sartre’s seminal treatise on existentialism. “This is a philosophy to be reckoned with, both for its own intrinsic power and as a profound symptom of our time” (The New York Times).\n" +
                        "\n" +
                        "In 1943, Jean-Paul Sartre published his masterpiece, Being and Nothingness, and laid the foundation of his legacy as one of the greatest twentieth century philosophers. A brilliant and radical account of the human condition, Being and Nothingness explores what gives our lives significance.");
        StoreStorage.getStorage().getShelfMap().put(book15,book15.getItemLocation());

        Book book16 = new Book("The Myth of Sisyphus", "Albert Camus", ItemGenre.FICTION, 400, 5, 44, "L3", "books/mythofsisyphus.jpg",
                "One of the most influential works of this century, this is a crucial exposition of existentialist thought. Influenced by works such as Don Juan and the novels of Kafka, these essays begin with a meditation on suicide: the question of living or not living in an absurd universe devoid of order or meaning. With lyric eloquence, Camus posits a way out of despair, reaffirming the value of personal existence, and the possibility of life lived with dignity and authenticity.");
        StoreStorage.getStorage().getShelfMap().put(book16,book16.getItemLocation());

        Book book17 = new Book("The Gulag Archipelago", "Aleksandr Solzhenitsyn", ItemGenre.HISTORY, 720, 5, 24, "H2", "books/gulag.jpg",
                "A vast canvas of camps, prisons, transit centres and secret police, of informers and spies and interrogators but also of everyday heroism, The Gulag Archipelago is Aleksandr Solzhenitsyn's grand masterwork. Based on the testimony of some 200 survivors, and on the recollection of Solzhenitsyn's own eleven years in labour camps and exile, it chronicles the story of those at the heart of the Soviet Union who opposed Stalin, and for whom the key to survival lay not in hope but in despair.\n" +
                        "\n" +
                        "A thoroughly researched document and a feat of literary and imaginative power, this edition of The Gulag Archipelago was abridged into one volume at the author's wish and with his full co-operation.");
        StoreStorage.getStorage().getShelfMap().put(book17,book17.getItemLocation());

        Book book18 = new Book("Capitalism and Freedom", "Milton Friedman", ItemGenre.HISTORY, 600, 5, 12, "H1", "books/capitalismandfreedom.jpg",
                "How can we benefit from the promise of government while avoiding the threat it poses to individual freedom? Milton Friedman presents his view of the proper role of competitive capitalism both as a device for achieving economic freedom and a necessary condition for political freedom");
        StoreStorage.getStorage().getShelfMap().put(book18,book18.getItemLocation());

        Book book19 = new Book("Resurrection", "Leo Tolstoy", ItemGenre.FICTION, 220, 5, 25, "L8", "books/resurrection.jpg",
                "This powerful novel, Tolstoy's third major masterpiece, after War and Peace and Anna Karenina, begins with a courtroom drama (the finest in Russian literature) all the more stunning for being based on a real-life event. Dmitri Nekhlyudov, called to jury service, is astonished to see in the dock, charged with murder, a young woman whom he once seduced, propelling her into prostitution. She is found guilty on a technicality, and he determines to overturn the verdict. This pitches him into a hellish labyrinth of Russian courts, prisons and bureaucracy, in which the author loses no opportunity for satire and bitter criticism of a state system (not confined to that country) of cruelty and injustice. This is Dickens for grown-ups, involving a hundred characters, Crime and Punishment brought forward half a century. With unforgettable set-pieces of sexual passion, conflict and social injustice, Resurrection proceeds from brothel to court-room, stinking cells to offices of state, luxury apartments to filthy life in Siberia. The ultimate crisis of moral responsibility embroils not only the famous author and his hero, but also you and me. Can we help resolve the eternal issues of law and imprisonment?");
        StoreStorage.getStorage().getShelfMap().put(book19,book19.getItemLocation());

        Book book20 = new Book("Demons", "Fyodor Dostoevsky", ItemGenre.FICTION, 400, 5, 15, "L7", "books/demons.jpg",
                "Demons, also known as The Possessed or The Devils, is a dark masterpiece that evokes a world where the lines between and good and evil long ago became blurred. This Penguin Classics edition of Fyodor Dostoyevsky's Demons is translated by Robert A. Maguire and edited by Ronald Meyer, with an introduction by Robert L. Belknap.\n" +
                        "\n" +
                        "Pyotr Verkhovensky and Nikolai Stavrogin are the leaders of a Russian revolutionary cell. Their aim is to overthrow the Tsar, destroy society and seize power for themselves. Together they train terrorists who are willing to go to any lengths to achieve their goals - even if the mission means suicide. But when it seems their motley group is about to be discovered, will their recruits be willing to kill one of their own circle in order to cover their tracks? As the ensuing investigation and trial reveal the true identity of the murderer, Dostoyevsky's and everyone's faith in humanity is tested. Partly based on the real-life case of a student murdered by his fellow revolutionaries, Dostoyevsky's sprawling novel is a powerful and prophetic, yet lively and often comic depiction of nineteenth-century Russia, and a savage indictment of the madness and nihilism of those who use violence to serve their beliefs.\n" +
                        "\n" +
                        "Robert A. Maguire's superb translation captures Dostoyevsky's vigorous prose. In his introduction, Robert L. Belknap discusses Dostoyevsky's own revolutionary activities, his narrative technique and use of different genres, and the background of Radicalism in Imperial Russia. Edited by Ronald Meyer, this volume also includes a chronology, further reading, notes and a glossary.");
        StoreStorage.getStorage().getShelfMap().put(book20,book20.getItemLocation());

        Book book21 = new Book("Man's Search for Meaning", "Viktor E. Frankl", ItemGenre.PHILOSOPHY, 250, 5, 24, "PH4", "books/mansearchformeaning.jpg",
                "16 MILLION COPIES SOLD\n" +
                        "\n" +
                        "'A book to read, to cherish, to debate, and one that will ultimately keep the memories of the victims alive' John Boyne, author of The Boy in the Striped Pyjamas\n" +
                        "\n" +
                        "A prominent Viennese psychiatrist before the war, Viktor Frankl was uniquely able to observe the way that both he and others in Auschwitz coped (or didn't) with the experience. He noticed that it was the men who comforted others and who gave away their last piece of bread who survived the longest - and who offered proof that everything can be taken away from us except the ability to choose our attitude in any given set of circumstances. The sort of person the concentration camp prisoner became was the result of an inner decision and not of camp influences alone. Frankl came to believe man's deepest desire is to search for meaning and purpose. This outstanding work offers us all a way to transcend suffering and find significance in the art of living.");
        StoreStorage.getStorage().getShelfMap().put(book21,book21.getItemLocation());

        Book book22 = new Book("The Psychopath Test", "Jon Ronson", ItemGenre.PSYCHOLOGY, 320, 5, 14, "PS5", "books/psychologicaltest.jpg",
                "What if society wasn't fundamentally rational, but was motivated by insanity? This thought sets Jon Ronson on an utterly compelling adventure into the world of madness.\n" +
                        "\n" +
                        "Along the way, Jon meets psychopaths, those whose lives have been touched by madness and those whose job it is to diagnose it, including the influential psychologist who developed the Psychopath Test, from whom Jon learns the art of psychopath-spotting. A skill which seemingly reveals that madness could indeed be at the heart of everything . . .\n" +
                        "\n" +
                        "Combining Jon Ronson's trademark humour, charm and investigative incision, The Psychopath Test is both entertaining and honest, unearthing dangerous truths and asking serious questions about how we define normality in a world where we are increasingly judged by our maddest edges.\n" +
                        "\n" +
                        "'The belly laughs come thick and fast - my God, he is funny . . . provocative and interesting' - Observer");
        StoreStorage.getStorage().getShelfMap().put(book22,book22.getItemLocation());

        Book book23 = new Book("Chronicles : On Our Troubled Times", "Thomas Piketty", ItemGenre.HISTORY, 240, 5, 14, "H7", "books/chronicles.jpg",
                "The return of the best-selling, award-winning economist extraordinaire\n" +
                        "\n" +
                        "With the same powerful evidence, and range of reference, as his global bestseller Capital in the Twenty-First Century - and in columns of 700 words, rather than 700 pages - Chronicles sets out Thomas Piketty's analysis of the financial crisis, what has happened since and where we should go from here.\n" +
                        "\n" +
                        "Tackling a wider range of subjects than in Capital, from productivity in Britain to Barack Obama, it comprises the very best of his writing for Liberation from the past ten years. Now, translated into English for the first time, it will further cement Piketty's reputation as the world's leading thinker today.");
        StoreStorage.getStorage().getShelfMap().put(book23,book23.getItemLocation());

        Book book24 = new Book("The Righteous Mind", "Jonathan Haidt", ItemGenre.PSYCHOLOGY, 560, 4, 68, "PS2", "books/righteousmind.jpg",
                "Presents a groundbreaking investigation into the origins of morality at the core of religion and politics, offering scholarly insight into the motivations behind cultural clashes that are polarizing America.");
        StoreStorage.getStorage().getShelfMap().put(book24,book24.getItemLocation());

        Book book25 = new Book("Don Quixote", "Miguel de Cervantes Saavedra", ItemGenre.FICTION, 650, 5, 74, "L9", "books/donquixote.jpg",
                "Don Quixote has become so entranced by reading chivalric romances that he determines to become a knight-errant himself. In the company of his faithful squire, Sancho Panza, his exploits blossom in all sorts of wonderful ways. While Quixote's fancy often leads him astray—he tilts at windmills, imagining them to be giants—Sancho acquires cunning and a certain sagacity. Sane madman and wise fool, they roam the world together, and together they have haunted readers' imaginations for nearly four hundred years.\n" +
                        "\n" +
                        "With its experimental form and literary playfulness, Don Quixote has been generally recognized as the first modern novel. The book has been enormously influential on a host of writers, from Fielding and Sterne to Flaubert, Dickens, Melville, and Faulkner, who reread it once a year, \"just as some people read the Bible.\"");
        StoreStorage.getStorage().getShelfMap().put(book25,book25.getItemLocation());

        Book book26 = new Book("Repetition and Philosophical Crumbs", "Soren Kierkegaard", ItemGenre.PHILOSOPHY, 410, 5, 84, "PH12", "books/repititionkierkegaard.jpg",
                "'The love of repetition is in truth the only happy love'\n" +
                        "\n" +
                        "So says Constantine Constantius on the first page of Kierkegaard's Repetition. Life itself, according to Kierkegaard's pseudonymous narrator, is a repetition, and in the course of this witty, playful work Constantius explores the nature of love and happiness, the passing of time and the importance of moving forward (and backward). The ironically entitled Philosophical Crumbs pursues the investigation of faith and love and their tense relationship with reason.");
        StoreStorage.getStorage().getShelfMap().put(book26,book26.getItemLocation());

        Book book27 = new Book("The Concept of Anxiety", "Soren Kierkegaard", ItemGenre.PHILOSOPHY, 675, 4, 75, "PH18", "books/conceptanxiety.jpg",
                "First published in 1844, Soren Kierkegaard's concise treatise identified--long before Freud--anxiety as a profound human condition, portraying human existence largely as a constant struggle with our own spiritual identities. Brilliantly synthesizing human insights with Christian dogma, Kierkegaard presented The Concept of Anxiety as a landmark \"psychological deliberation,\" suggesting that our only hope in overcoming anxiety was not through \"powder and pills\" but by embracing it with open arms. While Kierkegaard's Danish prose is surprisingly rich, previous translations--the most recent in 1980--have marginalized the work with alternately florid or slavishly wooden language. With a vibrancy never seen before in English, Alastair Hannay, the world's foremost Kierkegaard scholar, re-creates its natural rhythm, eager that this overlooked classic will not only become as celebrated as Fear and Trembling, The Sickness unto Death, and Either/Or but also be revivified as the seminal work of existentialism and moral psychology that it is.");
        StoreStorage.getStorage().getShelfMap().put(book27,book27.getItemLocation());

        Book book28 = new Book("Papers And Journals", "Soren Kierkegaard", ItemGenre.PHILOSOPHY, 844, 5, 3, "PH16", "books/papersandjournals.jpg",
                "One of the greatest thinkers of the nineteenth century, Søren Kierkegaard (1814-55) often expressed himself through pseudonyms and disguises. Taken from his personal writings, these private reflections reveal the development of his own thought and personality, from his time as a young student to the deep later internal conflict that formed the basis for his masterpiece of duality Either/Or and beyond. Expressing his beliefs with a freedom not seen in works he published during his lifetime, Kierkegaard here rejects for the first time his father's conventional Christianity and forges the revolutionary idea of the 'leap of faith' required for true religious belief. A combination of theoretical argument, vivid natural description and sharply honed wit, the Papers and Journals reveal to the full the passionate integrity of his lifelong efforts 'to find a truth which is truth for me'.");
        StoreStorage.getStorage().getShelfMap().put(book28,book28.getItemLocation());

        Book book29 = new Book("The Sorrows of Young Werther", "J W Goethe", ItemGenre.FICTION, 392, 5, 23, "L9", "books/sorrowsofyoungwerther.jpg",
                "A key work in the German 'Sturm und Drang' movement, Johann Goethe's autobiographical epistolary novel The Sorrows of Young Werther is a defining moment in early Romanticism, which has influenced writers from Mary Shelley to Thomas Mann. This Penguin Classics edition is translated from with an introduction by Michael Hulse.\n" +
                        "\n" +
                        "Visiting an idyllic German village, Werther, a sensitive young man, meets and falls in love with sweet-natured Charlotte. Although he realises that she is to marry Albert, he is unable to subdue his passion and his infatuation torments him to the point of despair. The first great 'confessional' novel, The Sorrows of Young Werther draws both on Goethe's own unrequited love for Charlotte Buff and on the death of his friend Karl Wilhelm Jerusalem. The book was an immediate success, and a cult rapidly grew up around it, resulting in numerous imitations as well as violent criticism and suppression on the grounds of its apparent support of suicide. Goethe's sensitive exploration of the mind of an artist at odds with society and ill-equipped to cope with life is now considered the first great tragic novel of European literature.\n" +
                        "\n" +
                        "This edition includes notes and an introduction by Michael Hulse, who explores the origins of the novel in the author's life and examines its impact on European culture.\n");
        StoreStorage.getStorage().getShelfMap().put(book29,book29.getItemLocation());

        Book book30 = new Book("Nausea", "Jean-Paul Sartre", ItemGenre.FICTION, 486, 5, 20, "L4", "books/nausea.jpg",
                "Jean-Paul Sartre's first published novel, Nausea is both an extended essay on existentialist ideals, and a profound fictional exploration of a man struggling to restore a sense of meaning to his life. This Penguin Modern Classics edition is translated from the French by Robert Baldick with an introduction by James Wood.\n" +
                        "\n" +
                        "Nausea is both the story of the troubled life of an introspective historian, Antoine Roquentin, and an exposition of one of the most influential and significant philosophical attitudes of modern times - existentialism. The book chronicles his struggle with the realisation that he is an entirely free agent in a world devoid of meaning; a world in which he must find his own purpose and then take total responsibility for his choices. A seminal work of contemporary literary philosophy, Nausea evokes and examines the dizzying angst that can come from simply trying to live.");
        StoreStorage.getStorage().getShelfMap().put(book30,book30.getItemLocation());

        Book book31 = new Book("The Hunchback of Notre-Dame", "Victor Hugo", ItemGenre.FICTION, 677, 5, 14, "L7", "books/hunchbackofnotredame.jpg",
                "Hugo's grand medieval melodrama tells the story of the beautiful Esmeralda, a gypsy girl loved by three men: Archdeacon Frollo, his adoptive son Quasimodo, bell-ringer of Notre-Dame cathedral, and Captain Phoebus. Falsely accused of trying to murder Phoebus, who attempts to rape her, Esmeralda is sentenced to death and rescued from the gallows by Quasimodo who defends her to the last.\n\n" +
                        "The subject of many adaptations for stage and screen, this remains perhaps one of the most romantic yet gripping stories ever told.");
        StoreStorage.getStorage().getShelfMap().put(book31,book31.getItemLocation());

        Book book32 = new Book("The Unconscious", "Sigmund Freud", ItemGenre.PSYCHOLOGY, 474, 5, 11, "PS8", "books/theunconscious.jpg",
                "One of Freud's central achievements was to demonstrate how unacceptable thoughts and feelings are repressed into the unconscious, from where they continue to exert a decisive influence over our lives.\n" +
                        "\n" +
                        "This volume contains a key statement about evidence for the unconscious, and how it works, as well as major essays on all the fundamentals of mental functioning. Freud explores how we are torn between the pleasure principle and the reality principle, how we often find ways both to express and to deny what we most fear, and why certain men need fetishes for their sexual satisfaction. His study of our most basic drives, and how they are transformed, brilliantly illuminates the nature of sadism, masochism, exhibitionism and voyeurism.");
        StoreStorage.getStorage().getShelfMap().put(book32,book32.getItemLocation());

        Book book33 = new Book("Civilization and Its Discontents", "Sigmund Freud", ItemGenre.PSYCHOLOGY, 415, 5, 12, "PS2", "books/civilisationanddiscontents.jpg",
                "In what remains one of his most seminal papers, Freud considers the incompatibility of civilisation and individual happiness, and the tensions between the claims of society and the individual. We all know that living in civilised groups means sacrificing a degree of personal interest, but couldn't you argue that it in fact creates the conditions for our happiness? Freud explores the arguments and counter-arguments surrounding this proposition, focusing on what he perceives to be one of society's greatest dangers; 'civilised' sexual morality. After all, doesn't repression of sexuality deeply affect people and compromise their chances of happiness?");
        StoreStorage.getStorage().getShelfMap().put(book33,book33.getItemLocation());

        Book book34 = new Book("Think Again", "Adam Grant", ItemGenre.PSYCHOLOGY, 693, 5, 18, "PS6", "books/thinkagain.jpg",
                "Discover the critical art of rethinking: how questioning your opinions can position you for excellence at work and wisdom in life\n" +
                        "\n" +
                        "Intelligence is usually seen as the ability to think and learn, but in a rapidly changing world, the most crucial skill may be the ability to rethink and unlearn. Recent global and political changes have forced many of us to re-evaluate our opinions and decisions. Yet we often still favour the comfort of conviction over the discomfort of doubt, and prefer opinions that make us feel good, instead of ideas that make us think hard. Intelligence is no cure, and can even be a curse. The brighter we are, the blinder we can become to our own limitations.\n" +
                        "\n" +
                        "Adam Grant - Wharton's top-rated professor and #1 bestselling author - offers bold ideas and rigorous evidence to show how we can embrace the joy of being wrong, encourage others to rethink topics as wide-ranging as abortion and climate change, and build schools, workplaces, and communities of lifelong learners. You'll learn how an international debate champion wins arguments, a Black musician persuades white supremacists to abandon hate, and how a vaccine whisperer convinces anti-vaxxers to immunize their children. Think Again is an invitation to let go of stale opinions and prize mental flexibility, humility, and curiosity over foolish consistency. If knowledge is power, knowing what you don't know is wisdom.");
        StoreStorage.getStorage().getShelfMap().put(book34,book34.getItemLocation());

        Book book35 = new Book("Fathers and Sons", "Ivan Turgenev", ItemGenre.FICTION, 466, 5, 18, "L4", "books/fathersandsons.jpg",
                "Ivan Turgenev's Fathers and Sons explores the ageless conflict between generations through a period in Russian history when a new generation of revolutionary intellectuals threatened the state. This Penguin Classics edition is translated from the Russian by Peter Carson, with an introduction by Rosamund Bartlett and an afterword by Tatyana Tolstaya.\n" +
                        "\n" +
                        "Returning home after years away at university, Arkady is proud to introduce his clever friend Bazarov to his father and uncle. But their guest soon stirs up unrest on the quiet country estate - his outspoken nihilist views and his scathing criticisms of the older men expose the growing distance between Arkady and his father. And when Bazarov visits his own doting but old-fashioned parents, his disdainful rejection of traditional Russian life causes even further distress. In Fathers and Sons, Turgeneve created a beautifully-drawn and highly influential portrayal of the clash between generations, at a time just before the end of serfdom, when the refined yet vanishing landowning class was being overturned by a brash new breed that strove to change the world.\n" +
                        "\n" +
                        "Peter Carson's elegant, naturalistic new translation brings Turgenev's masterpiece to life for a new generation of readers. In her introduction, Rosamund Bartlett discusses the novel's subtle characterisation and the immense social changes that took place in the 1850s Russia of Fathers and Sons. This edition also includes a chronology, suggested further reading and notes.");
        StoreStorage.getStorage().getShelfMap().put(book35,book35.getItemLocation());

        Book book36 = new Book("The Iliad", "Homer", ItemGenre.FICTION, 704, 5, 6, "L7", "books/iliad.jpg",
                "One of the greatest epics in Western literature, THE ILIAD recounts the story of the Trojan wars. This timeless poem still vividly conveys the horror and heroism of men and gods battling amidst devastation and destruction, as it moves to its tragic conclusion. In his introduction, Bernard Knox observes that although the violence of the Iliad is grim and relentless, it co-exists with both images of civilized life and a poignant yearning for peace.");
        StoreStorage.getStorage().getShelfMap().put(book36,book36.getItemLocation());

        Book book37 = new Book("The Odyssey", "Homer", ItemGenre.FICTION, 757, 5, 14, "L7", "books/theodyssey.jpg",
                "Homer's best-loved and most accessible poem, recounting the great wandering of Odysseus during his ten-year voyage back home to Ithaca, after the Trojan War. A superb new verse translation, now published in trade paperback, before the standard Penguin Classic B format.");
        StoreStorage.getStorage().getShelfMap().put(book37,book37.getItemLocation());

        Book book38 = new Book("Dracula", "Bram Stoker", ItemGenre.FICTION, 432, 5, 14, "L2", "books/dracula.jpg",
                "'There he lay looking as if youth had been half-renewed, for the white hair and moustache were changed to dark iron-grey, the cheeks were fuller, and the white skin seemed ruby-red underneath; the mouth was redder than ever, for on the lips were gouts of fresh blood, which trickled from the corners of the mouth and ran over the chin and neck. Even the deep, burning eyes seemed set amongst the swollen flesh, for the lids and pouches underneath were bloated. It seemed as if the whole awful creature were simply gorged with blood; he lay like a filthy leech, exhausted with his repletion.'\n" +
                        "\n" +
                        "Thus Bram Stoker, one of the greatest exponents of the supernatural narrative, describes the demonic subject of his chilling masterpiece Dracula, a truly iconic and unsettling tale of vampirism.");
        StoreStorage.getStorage().getShelfMap().put(book38,book38.getItemLocation());

        Book book39 = new Book("Selected Stories of Anton Chekhov", "Anton Chekhov", ItemGenre.FICTION, 660, 5, 5, "L19", "books/antonchekhov.jpg",
                "An anthology of short fiction by the great Russian writer encompasses thirty of his finest tales, including \"The Huntsman,\" \"The Boring Story,\" \"The Lady with the Little Dog,\" \"Ward No. 6,\" \"The Student,\" \"The FiancTe,\" and \"The Bishop,\" representing various periods in his creative work.");
        StoreStorage.getStorage().getShelfMap().put(book39,book39.getItemLocation());

        Book book40 = new Book("Giovanni's Room", "James Baldwin", ItemGenre.FICTION, 486, 5, 4, "L14", "books/giovanniroom.jpg",
                "Baldwin's ground-breaking second novel, which established him as one of the great American writers of his time\n" +
                        "\n" +
                        "David, a young American in 1950s Paris, is waiting for his fiancée to return from vacation in Spain. But when he meets Giovanni, a handsome Italian barman, the two men are drawn into an intense affair. After three months David's fiancée returns and, denying his true nature, he rejects Giovanni for a 'safe' future as a married man. His decision eventually brings tragedy.\n" +
                        "\n" +
                        "Filled with passion, regret and longing, this story of a fated love triangle has become a landmark of gay writing. James Baldwin caused outrage as a black author writing about white homosexuals, yet for him the issues of race, sexuality and personal freedom were eternally intertwined.\n" +
                        "\n" +
                        "'Exquisite... a feat of fire-breathing, imaginative daring' Guardian");
        StoreStorage.getStorage().getShelfMap().put(book40,book40.getItemLocation());

        Book book41 = new Book("One Day in the Life of Ivan Denisovich", "Aleksandr Solzhenitsyn", ItemGenre.FICTION, 717, 5, 14, "L22", "books/ivandenisovich.jpg",
                "The first published novel from the controversial Nobel Prize winning Russian author of The Gulag Archipelago.\n" +
                        "\n" +
                        "In the madness of World War II, a dutiful Russian soldier is wrongfully convicted of treason and sentenced to ten years in a Siberian labor camp. So begins this masterpiece of modern Russian fiction, a harrowing account of a man who has conceded to all things evil with dignity and strength.\n" +
                        " \n" +
                        "First published in 1962, One Day in the Life of Ivan Denisovich is considered one of the most significant works ever to emerge from Soviet Russia. Illuminating a dark chapter in Russian history, it is at once a graphic picture of work camp life and a moving tribute to man’s will to prevail over relentless dehumanization.");
        StoreStorage.getStorage().getShelfMap().put(book41,book41.getItemLocation());

        Book book42 = new Book("The Trouble with Being Born", "E. M. Cioran", ItemGenre.PHILOSOPHY, 481, 4, 18, "PH7", "books/troublebeingborn.jpg",
                "'Not to be born is undoubtedly the best plan of all. Unfortunately it is within no one's reach.'\n" +
                        "\n" +
                        "In The Trouble With Being Born, E. M. Cioran grapples with the major questions of human existence: birth, death, God, the passing of time, how to relate to others and how to make ourselves get out of bed in the morning.\n" +
                        "\n" +
                        "In a series of interlinking aphorisms which are at once pessimistic, poetic and extremely funny, Cioran finds a kind of joy in his own despair, revelling in the absurdity and futility of our existence, and our inability to live in the world.\n" +
                        "\n" +
                        "Translated by Pulitzer Prize-winning poet and critic Richard Howard, The Trouble With Being Born is a provocative, illuminating testament to a singular mind.");
        StoreStorage.getStorage().getShelfMap().put(book42,book42.getItemLocation());

        Book book43 = new Book("King's Counsellor", "Alan Lascelles", ItemGenre.HISTORY, 744, 5, 14, "H5", "books/alanlascelles.jpg",
                "'Fascinating ... as much a contribution to royal legend as to the history of the war' Daily Telegraph\n" +
                        "\n" +
                        "As Assistant Private Secretary to four monarchs, 'Tommy' Lascelles had a ringside seat from which to observe the workings of the royal household and Downing Street during the first half of the 20th century.\n" +
                        "\n" +
                        "These fascinating diaries begin with Edward VIII's abdication and end with George VI's death and his daughter Elizabeth's Coronation. In between we see George VI at work and play, a portrait more intimate than any other previously published.\n" +
                        "\n" +
                        "This compelling account also includes Princess Margaret's relationship with Peter Townsend, and throws an intriguing new light on the way in which King George VI and Winston Churchill worked together during the Second World War.");
        StoreStorage.getStorage().getShelfMap().put(book43,book43.getItemLocation());

        Book book44 = new Book("The Alienist", "Caleb Carr", ItemGenre.FICTION, 496, 5, 33, "L1", "books/thealienist.jpg",
                "The internationally bestselling historical thriller, soon to be a Netflix series starring Luke Evans, Dakota Fanning and Daniel Brühl.\n" +
                        "\n" +
                        "Some things never change.\n" +
                        "\n" +
                        "New York City, 1896. Hypocrisy in high places is rife, police corruption commonplace, and a brutal killer is terrorising young male prostitutes.\n" +
                        "\n" +
                        "Unfortunately for Police Commissioner Theodore Roosevelt, the psychological profiling of murderers is a practice still in its infancy, struggling to make headway against the prejudices of those who prefer the mentally ill - and the 'alienists' who treat them - to be out of sight as well as out of mind.\n" +
                        "\n" +
                        "But as the body count rises, Roosevelt swallows his doubts and turns to the eminent alienist Dr Laszlo Kreizler to put a stop to the bloody murders - giving Kreizler a chance to take him further into the dark heart of criminality, and one step closer to death.");
        StoreStorage.getStorage().getShelfMap().put(book44,book44.getItemLocation());

        Book book45 = new Book("The Song of Achilles", "Madeline Miller", ItemGenre.FICTION, 360, 5, 14, "L3", "books/songofachilles.jpg",
                "Achilles, \"the best of all the Greeks,\" son of the cruel sea goddess Thetis and the legendary king Peleus, is strong, swift, and beautiful, irresistible to all who meet him. Patroclus is an awkward young prince, exiled from his homeland after an act of shocking violence. Brought together by chance, they forge an inseparable bond, despite risking the gods' wrath.\n" +
                        "\n" +
                        "They are trained by the centaur Chiron in the arts of war and medicine, but when word comes that Helen of Sparta has been kidnapped, all the heroes of Greece are called upon to lay siege to Troy in her name. Seduced by the promise of a glorious destiny, Achilles joins their cause, and torn between love and fear for his friend, Patroclus follows. Little do they know that the cruel Fates will test them both as never before and demand a terrible sacrifice.");
        StoreStorage.getStorage().getShelfMap().put(book45,book45.getItemLocation());

        Book book46 = new Book("Humiliated and Insulted", "Fyodor Dostoevsky", ItemGenre.FICTION, 425, 5, 4, "L7", "books/humiliatedandinsulted.jpg",
                "First published in 1861, Humiliated and Insulted plunges the reader into a world of moral degradation, childhood trauma, unrequited love and irreconcilable relationships. At the centre of the story are a young struggling author, an orphaned teenager and a depraved aristocrat, who not only foreshadows the great figures of evil in Dostoevsky's later fiction, but is a powerful and original presence in his own right.\n" +
                        "\n" +
                        "This new translation catches the verve and tumult of the original, which - in concept and execution - affords a refreshingly unfamiliar glimpse of the author.");
        StoreStorage.getStorage().getShelfMap().put(book46,book46.getItemLocation());

        Book book47 = new Book("Notes from Underground and the Double", "Fyodor Dostoevsky", ItemGenre.FICTION, 423, 5, 25, "L7", "books/notesfromunderground.jpg",
                "'That sense of the meaninglessness of existence that runs through much of twentieth-century writing - from Conrad and Kafka, to Beckett and beyond - starts in Dostoyevsky's work' Malcolm Bradbury\n" +
                        "\n" +
                        "Alienated from society and paralysed by a sense of his own insignificance, the anonymous narrator of Dostoyevsky's Notes from Underground tells the story of his tortured life. With bitter irony, he describes his refusal to become a worker in the 'anthill' and his gradual withdrawal from society. The seemingly ordinary world of St Petersburg takes on a nightmarish quality in The Double when a government clerk encounters a man who looks exactly like him - his double perhaps, or possibly the darker side of his own personality. Like Notes from Underground, this is a masterly tragi-comic study of human consciousness.\n" +
                        "\n" +
                        "Translated by Ronald Wilks with an Introduction by Robert Louis Jackson");
        StoreStorage.getStorage().getShelfMap().put(book47,book47.getItemLocation());

        Book book48 = new Book("The Adolescent", "Fyodor Dostoevsky", ItemGenre.FICTION, 785, 5, 26, "L7", "books/theadolescent.jpg",
                "The illegitimate son of a landowner and his common-law peasant wife, Arkady Dolgoruky has scarcely seen these parents during his nineteen years of life. In a narrative combining farce and pathos, Dostoevsky describes Arkady's visit to St Petersburg in search of the 'accidental family' who have dominated his dreams. The confrontation with them does not turn out quite as he imagined it. This relatively late novel, written in the last decade of the author's life, nevertheless captures the exuberance and embarrassments, the bliss and bale of adolescence in all its volatility and uncertainty.");
        StoreStorage.getStorage().getShelfMap().put(book48,book48.getItemLocation());

        Book book49 = new Book("The Gambler and Other Stories", "Fyodor Dostoevsky", ItemGenre.FICTION, 640, 5, 14, "L8", "books/thegambler.jpg",
                "The Gambler and Other Stories is Fyodor Dostoyevsky's collection of one novella and six short stories reflecting his own life - indeed, 'The Gambler', a story of a young tutor in the employment of a formerly wealthy Russian General, was written under a strict deadline so he could pay off his roulette debts. This volume includes 'Bobok', the tale of a frustrated writer visiting a cemetery and enjoying the gossip of the dead; 'The Dream of a Ridiculous Man', the story of one man's plan to commit suicide and the troubling dream that follows, as well as 'A Christmas Party and a Wedding', 'A Nasty Story' and 'The Meek One'.");
        StoreStorage.getStorage().getShelfMap().put(book49,book49.getItemLocation());

        Book book50 = new Book("Blood Meridian", "Cormac McCarthy", ItemGenre.FICTION, 474, 5, 8, "L14", "books/bloodmeridian.jpg",
                "Brutally violent, Blood Meridian is the story of one teenage runaway in the nineteenth-century American South, as a sadistic gang unleashes its massacre across the desert land. It is the work that sealed Cormac McCarthy's reputation as one of the twentieth century's greatest writers - his magnum opus.\n" +
                        "\n" +
                        "'[A] brilliant, uncompromising work of fiction - imagine if the authors of the King James Bible, their hands guided by Satan, wrote a western' - The Times\n" +
                        "\n" +
                        "Through the hostile landscape of the Texas-Mexico border wanders the Kid, a fourteen year-old Tennessean who is quickly swept up in the relentless tide of blood.\n" +
                        "\n" +
                        "A group known as the Glanton gang hunt Indigenous Americans, collecting scalps as their bloody trophies. At the centre of this violence stands Judge Holden: a massive, hairless man, mysterious if not supernatural, erudite and cold-blooded. He is singularly extreme in his sadistic violence.\n" +
                        "\n" +
                        "But the apparent chaos is not without order - the Glanton gang, too, are stalked as prey.\n" +
                        "\n" +
                        "Read as both a brilliant subversion of the Western novel and a blazing example of that form, it is a powerful, mesmerizing and savagely beautiful novel - and one of the most important works in American fiction of the last century.");
        StoreStorage.getStorage().getShelfMap().put(book50,book50.getItemLocation());

        Book book51 = new Book("No Longer Human", "Osamu Dazai", ItemGenre.FICTION, 579, 5, 29, "L4", "books/nolongerhuman.jpg",
                "Mine has been a life of much shame. I can't even guess myself what it must be to live the life of a human being.\n" +
                        "\n" +
                        "Portraying himself as a failure, the protagonist of Osamu Dazai's No Longer Human narrates a seemingly normal life even while he feels himself incapable of understanding human beings. His attempts to reconcile himself to the world around him begin in early childhood, continue through high school, where he becomes a \"clown\" to mask his alienation, and eventually lead to a failed suicide attempt as an adult. Without sentimentality, he records the casual cruelties of life and its fleeting moments of human connection and tenderness.\n" +
                        "\n" +
                        "Still one of the ten bestselling books in Japan, No Longer Human is an important and unforgettable modern classic: \"The struggle of the individual to fit into a normalizing society remains just as relevant today as it was at the time of writing.\" (The Japan Times)");
        StoreStorage.getStorage().getShelfMap().put(book51,book51.getItemLocation());

        Book book52 = new Book("War and Peace", "Leo Tolstoy", ItemGenre.FICTION, 1203, 5, 6, "L1", "books/warandpeace.jpg",
                "A beautiful Penguin Classics clothbound edition of Tolstoy's magnificent epic novel of love, conflict, fate and human life in all its imperfection and grandeur\n" +
                        "\n" +
                        "At a glittering society party in St Petersburg in 1805, conversations are dominated by the prospect of war. Terror swiftly engulfs the country as Napoleon's army marches on Russia, and the lives of three young people are changed forever. The stories of quixotic Pierre, cynical Andrey and impetuous Natasha interweave with a huge cast, from aristocrats and peasants to soldiers and Napoleon himself. In War and Peace, Tolstoy entwines grand themes - conflict and love, birth and death, free will and faith - with unforgettable scenes of nineteenth-century Russia, to create a magnificent epic of human life in all its imperfection and grandeur.\n" +
                        "\n" +
                        "Translated with an introduction and notes by Anthony Briggs, and with an afterword by Orlando Figes");
        StoreStorage.getStorage().getShelfMap().put(book52,book52.getItemLocation());

        Book book53 = new Book("The Idiot", "Fyodor Dostoevsky", ItemGenre.FICTION, 486, 5, 14, "L15", "books/theidiot.jpg",
                "Fyodor Dostoyevsky's The Idiot is an immaculate portrait of innocence tainted by the brutal reality of human greed. This Penguin Classics edition is translated from the Russian by David McDuff, with an introduction by William Mills Todd III.\n" +
                        "\n" +
                        "Returning to St Petersburg from a Swiss sanatorium, the gentle and naïve epileptic Prince Myshkin - the titular 'idiot' - pays a visit to his distant relative General Yepanchin and proceeds to charm the General, his wife, and his three daughters. But his life is thrown into turmoil when he chances on a photograph of the beautiful Nastasya Filippovna. Utterly infatuated with her, he soon finds himself caught up in a love triangle and drawn into a web of blackmail, betrayal, and finally, murder. Inspired by an image of Christ's suffering Dostoyevsky sought to portray in Prince Myshkin the purity of a 'truly beautiful soul' and explore the perils that innocence and goodness face in a corrupt world.\n" +
                        "\n" +
                        "David McDuff's new translation brilliantly captures the novel's idiosyncratic and dream-like language and the nervous, elliptic flow of the narrative. This edition also contains a new introduction by William Mills Todd III, which is a fascinating examination of the pressures on Dostoyevsky as he wrote the story of his Christ-like hero.");
        StoreStorage.getStorage().getShelfMap().put(book53,book53.getItemLocation());

        Book book54 = new Book("Anna Karenina", "Leo Tolstoy", ItemGenre.FICTION, 192, 5, 9, "L2", "books/annakarenina.jpg",
                "Translated by Louise and Aylmer Maude. Introduction and Notes by E.B. Greenwood, University of Kent.\n" +
                        "\n" +
                        "Anna Karenina is one of the most loved and memorable heroines of literature. Her overwhelming charm dominates a novel of unparalleled richness and density.\n" +
                        "\n" +
                        "Tolstoy considered this book to be his first real attempt at a novel form, and it addresses the very nature of society at all levels,- of destiny, death, human relationships and the irreconcilable contradictions of existence. It ends tragically, and there is much that evokes despair, yet set beside this is an abounding joy in life's many ephemeral pleasures, and a profusion of comic relief.");
        StoreStorage.getStorage().getShelfMap().put(book54,book54.getItemLocation());

        Book book55 = new Book("Little Women", "Louisa May Alcott", ItemGenre.FICTION, 438, 5, 14, "L7", "books/littlewomen.jpg",
                "A restless tomboy with a wild imagination, Jo March bridles against societal conventions. She has no interest in becoming a lady; she will become a writer. Fortunately for Jo, her family supports her ambitions and understands her eccentricities. With their father serving as a chaplain in the Union Army and little money coming in, Jo and her three sisters work hard to help their mother keep the household afloat.");
        StoreStorage.getStorage().getShelfMap().put(book55,book55.getItemLocation());

        Book book56 = new Book("The Sailor Who Fell from Grace with the Sea", "Yukio Mishima", ItemGenre.FICTION, 517, 5, 10, "L7", "books/thesailorgrace.jpg",
                "'Mishima's greatest novel, and one of the greatest of the past century' The Times\n" +
                        "\n" +
                        "A band of savage thirteen-year-old boys reject the adult world as illusory, hypocritical, and sentimental, and train themselves in a brutal callousness they call 'objectivity'. When the mother of one of them begins an affair with a ship's officer, he and his friends idealise the man at first; but it is not long before they conclude that he is in fact soft and romantic.\n" +
                        "\n" +
                        "They regard this disillusionment as an act of betrayal on his part - and the retribution is deliberate and horrifying.\n" +
                        "\n" +
                        "VINTAGE JAPANESE CLASSICS - five masterpieces of Japanese fiction in gorgeous new gift editions.");
        StoreStorage.getStorage().getShelfMap().put(book56,book56.getItemLocation());

        Book book57 = new Book("Ulysses", "James Joyce", ItemGenre.FICTION, 471, 5, 21, "L6", "books/ulysses.jpg",
                "'Everybody knows now that Ulysses is the greatest novel of the century' Anthony Burgess, Observer\n" +
                        "\n" +
                        "Following the events of one single day in Dublin, the 16th June 1904, and what happens to the characters Stephen Dedalus, Leopold Bloom and his wife Molly, Ulysses is a monument to the human condition. It has survived censorship, controversy and legal action, and even been deemed blasphemous, but remains an undisputed modernist classic: ceaselessly inventive, garrulous, funny, sorrowful, vulgar, lyrical and ultimately redemptive. It confirms Joyce's belief that literature 'is the eternal affirmation of the spirit of man'.\n" +
                        "\n" +
                        "'The most important expression which the present age has found; it is a book to which we are all indebted, and from which none of us can escape' T. S. Eliot\n" +
                        "\n" +
                        "'Intoxicating ... a towering work, in its word play surpassing even Shakespeare' Guardian");
        StoreStorage.getStorage().getShelfMap().put(book57,book57.getItemLocation());

        Book book58 = new Book("Notes from a Dead House", "Fyodor Dostoevsky", ItemGenre.FICTION, 646, 5, 14, "L7", "books/deadhouse.jpg",
                "In 1849 the young Fyodor Dostoevsky was sentenced to four years' hard labour in a Siberian prison camp for advocating socialism. Notes from a Dead House (sometimes translated as The House of the Dead), the novel he wrote on his release, tells of shocking conditions, brutal punishments, and the psychological effects of the loss of freedom and hope; it describes the daily life of the prison community, the feuds and betrayals, the moments of comedy, the unexpected acts of kindness.\n\n" +
                        "To avoid censorship, Dostoevsky made his protagonist a common criminal, but the perspective is unmistakably his own. As a member of the nobility he had been despised by his fellow prisoners, most of whom were peasants - an experience shared in the book by Alexander Petrovich Goryanchikov, a nobleman who has killed his wife. Like his creator, Goryanchikov undergoes a transformation over the course of his ordeal, as he discovers 'deep, strong, beautiful natures' amongst even the roughest of the convicts. Notes from a Dead House shows the prison camp as a tragedy for the inmates and a tragedy for Russia. It endures today as a profound meditation on freedom.");
        StoreStorage.getStorage().getShelfMap().put(book58,book58.getItemLocation());

        Book book59 = new Book("The Book of Disquiet", "Fernando Pessoa", ItemGenre.PHILOSOPHY, 645, 5, 17, "L2", "books/bookofdisquiet.jpg",
                "With its astounding hardcover reviews Richard Zenith's new complete translation of THE BOOK OF DISQUIET has now taken on a similar iconic status to ULYSSES, THE TRIAL or IN SEARCH OF LOST TIME as one of the greatest but also strangest modernist texts. An assembly of sometimes linked fragments, it is a mesmerising, haunting 'novel' without parallel in any other culture.");
        StoreStorage.getStorage().getShelfMap().put(book59,book59.getItemLocation());

        Book book60 = new Book("A Mathematician's Lament", "Paul Lockhart", ItemGenre.EDUCATION, 677, 5, 14, "ED1", "books/amathematicianlaments.jpg",
                "\"One of the best critiques of current mathematics education I have ever seen.\"-Keith Devlin, math columnist on NPR's Morning Edition A brilliant research mathematician who has devoted his career to teaching kids reveals math to be creative and beautiful and rejects standard anxiety-producing teaching methods. Witty and accessible, Paul Lockhart's controversial approach will provoke spirited debate among educators and parents alike and it will alter the way we think about math forever. Paul Lockhart, has taught mathematics at Brown University and UC Santa Cruz. Since 2000, he has dedicated himself to K-12 level students at St. Ann's School in Brooklyn, New York.");
        StoreStorage.getStorage().getShelfMap().put(book60,book60.getItemLocation());

        Book book61 = new Book("A Mind at Play", "Jimmy Soni", ItemGenre.EDUCATION, 722, 5, 10, "ED4", "books/amindatplay.jpg",
                "Chronicles the life and times of the groundbreaking Information Age intellect, revealing how his discoveries and innovations set the stage for the digital era and influenced the work of collaborators and rivals.");
        StoreStorage.getStorage().getShelfMap().put(book61,book61.getItemLocation());

        Book book62 = new Book("A Portrait of the Artist as a Young Man", "James Joyce", ItemGenre.FICTION, 722, 5, 24, "L1", "books/aprotraitoftheartist.jpg",
                "The first, shortest, and most approachable of James Joyce's novels, A Portrait of the Artist as a Young Man portrays the Dublin upbringing of Stephen Dedalus, from his youthful days at Clongowes Wood College to his radical questioning of all convention. In doing so, it provides an oblique self-portrait of the young Joyce himself. Exuberantly inventive in style, the novel subtly and beautifully orchestrates the patterns of quotation and repetition instrumental in its hero's quest to create his own character, his own language, life, and art. This Penguin Classics Deluxe Edition, published for the novel's centennial, is the definitive text, authorized by the Joyce estate and collated from all known proofs, manuscripts, and impressions to reflect the author's original wishes.");
        StoreStorage.getStorage().getShelfMap().put(book62,book62.getItemLocation());

        Book book63 = new Book("Of Mice and Men", "John Steinbeck", ItemGenre.FICTION, 677, 5, 8, "L3", "books/ofmiceandmen.jpg",
                "Drifters in search of work, George and his childlike friend Lennie, have nothing in the world except the clothes on their back - and a dream that one day they will have some land of their own. Eventually they find work on a ranch in California's Salinas Valley, but their hopes are dashed as Lennie - struggling against extreme cruelty, misunderstanding and feelings of jealousy - becomes a victim of his own strength. Tackling universal themes of friendship and shared vision, and giving a voice to America's lonely and dispossessed, Of Mice and Men remains Steinbeck's most popular work, achieving success as a novel, Broadway play and three acclaimed films.");
        StoreStorage.getStorage().getShelfMap().put(book63,book63.getItemLocation());

        Book book64 = new Book("The Grapes of Wrath", "John Steinbeck", ItemGenre.FICTION, 471, 5, 4, "L7", "books/grapesofwrath.jpg",
                "'I've done my damndest to rip a reader's nerves to rags, I don't want him satisfied.'\n" +
                        "\n" +
                        "Shocking and controversial when it was first published, The Grapes of Wrath is Steinbeck's Pultizer Prize-winning epic of the Joad family, forced to travel west from Dust Bowl era Oklahoma in search of the promised land of California. Their story is one of false hopes, thwarted desires and powerlessness, yet out of their struggle Steinbeck created a drama that is both intensely human and majestic in its scale and moral vision.");
        StoreStorage.getStorage().getShelfMap().put(book64,book64.getItemLocation());

        Book book65 = new Book("Finnegans Wake", "James Joyce", ItemGenre.FICTION, 645, 5, 2, "L17", "books/finneganswake.jpg",
                "A daring work of experimental, Modernist genius, James Joyce's Finnegans Wake is one of the greatest literary achievements of the twentieth century, and the crowning glory of Joyce's life. The Penguin Modern Classics edition of includes an introduction by Seamus Deane\n" +
                        "\n" +
                        "'riverrun, past Eve and Adam's, from swerve of shore to bend of bay, brings us by a commodius vicus of recirculation back to Howth Castle and Environs'\n" +
                        "\n" +
                        "Joyce's final work, Finnegan's Wake is his masterpiece of the night as Ulysses is of the day. Supreme linguistic virtuosity conjures up the dark underground worlds of sexuality and dream. Joyce undermines traditional storytelling and all official forms of English and confronts the different kinds of betrayal - cultural, political and sexual - that he saw at the heart of Irish history. Dazzlingly inventive, with passages of great lyrical beauty and humour, Finnegans Wake remains one of the most remarkable works of the twentieth century.");
        StoreStorage.getStorage().getShelfMap().put(book65,book65.getItemLocation());

        Book book66 = new Book("Candide, or the Optimist", "Voltaire", ItemGenre.FICTION, 546, 5, 78, "L1", "books/candide.jpg",
                "Candide, or the Optimist is Voltaire's hilarious and deeply scathing satire on the Age of Enlightenment. This classic of French literature has been a bestseller for over two hundred years.\n" +
                        "\n" +
                        "Part of the Macmillan Collector's Library, a series of stunning, clothbound, pocket-sized classics with gold-foiled edges and ribbon markers. These beautiful books make perfect gifts or a treat for any book lover. This classic of French literature features an introduction by Dr Marine Ganofsky.\n" +
                        "\n" +
                        "Young nobleman Candide lives a sheltered and comfortable life under the tutorship of the ridiculous Dr Pangloss who espouses the prevailing 18th-century philosophy of Optimism. Following an indiscretion, Candide is cast out into the world which according to Pangloss is 'the best of all possible worlds'. But this is not so, Candide and his companions encounter nothing but ludicrous calamities in their madcap travels around the world - war crimes, earthquakes, inquisitions and chain gangs - all based with horrible closeness on real events of the 18th century.");
        StoreStorage.getStorage().getShelfMap().put(book66,book66.getItemLocation());

        Book book67 = new Book("Moby-Dick", "Herman Melville", ItemGenre.FICTION, 555, 5, 14, "L12", "books/mobydick.jpg",
                "Complete and unabridged.\n" +
                        "\n" +
                        "Teeming with ideas and imagery, and with its extraordinary intensity sustained by mischievous irony and moments of exquisite beauty, Moby-Dick is both a great American epic and a profoundly imaginative literary creation.\n" +
                        "\n" +
                        "Part of the Macmillan Collector's Library; a series of stunning, clothbound, pocket sized classics with gold foiled edges and ribbon markers. These beautiful books make perfect gifts or a treat for any book lover. This edition features an afterword by Nigel Cliff.\n" +
                        "\n" +
                        "On board the whaling ship Pequod a crew of wise men and fools, renegades and seeming phantoms is hurled through treacherous seas by crazed Captain Ahab, a man hell-bent on hunting down the mythic White Whale. Herman Melville transforms the little world of the whale ship into a crucible where mankind's fears, faith and frailties are pitted against a relentless fate.");
        StoreStorage.getStorage().getShelfMap().put(book67,book67.getItemLocation());

        Book book68 = new Book("The Hobbit", "J.R.R. Tolkien", ItemGenre.FICTION, 1410, 5, 6, "L1", "books/thehobbit.jpg",
                "A great modern classic and the prelude to The Lord of the Rings.\n" +
                        "\n" +
                        "Smaug certainly looked fast asleep, almost dead and dark, with scarcely a snore more than a whiff of unseen steam, when Bilbo peeped once more from the entrance. He was just about to step out on to the floor when he caught a sudden thin and piercing ray of red from under the drooping lid of Smaug’s left eye. He was only pretending to sleep! He was watching the tunnel entrance!\n" +
                        "\n" +
                        "Whisked away from his comfortable, unambitious life in his hobbit-hole in Bag End by Gandalf the wizard and a band of dwarves, Bilbo Baggins finds himself caught up in a plot to raid the treasure hoard of Smaug the Magnificent, a large and very dangerous dragon. Although quite reluctant to take part in this quest, Bilbo surprises even himself by his resourcefulness and his skill as a burglar!\n" +
                        "\n" +
                        "The text of this edition has been fully corrected and revised in collaboration with Christopher Tolkien and is accompanied by a wealth of beautiful watercolour paintings and delicate pencil drawings from Alan Lee.");
        StoreStorage.getStorage().getShelfMap().put(book68,book68.getItemLocation());

        Book book69 = new Book("The Silmarillion", "J.R.R. Tolkien", ItemGenre.FICTION, 1365, 5, 4, "L7", "books/thesilmarillion.jpg",
                "The Silmarillion is the core of J.R.R. Tolkien’s imaginative writing, a collection of narratives ranging in time from the Elder Days of Middle-earth, through the Second Age and the rise of Sauron, to the end of the War of the Ring.\n" +
                        "\n" +
                        "They are set in an age when Morgoth, the first Dark Lord, dwelt in Middle-earth, and the Elves made war upon him in his impenetrable fortress in Angband for the recovery of the Silmarils, three jewels containing the last remaining pure light of Valinor, seized by Morgoth and set in his iron crown.\n" +
                        "\n" +
                        "Accompanying these tales are several shorter works. The Ainulindalë is a myth of the Creation and in the Valaquenta the nature and powers of the gods is described. The Akallabêth recounts the downfall of the great island kingdom of Númenor at the end of the Second Age and Of the Rings of Power tells of the great events at the end of the Third Age, as told in The Lord of the Rings.\n" +
                        "\n" +
                        "Tolkien could not publish The Silmarillion in his lifetime, as it grew with him, so he would leave it to his son, Christopher, to edit the work from many manuscripts and bring his father’s great vision to publishable form, so completing the literary achievement of a lifetime. This special edition presents anew this seminal first step towards mapping out the posthumous publishing of Middle-earth, and the beginning of an illustrious forty years and more than twenty books celebrating his father’s legacy.");
        StoreStorage.getStorage().getShelfMap().put(book69,book69.getItemLocation());

        Book book70 = new Book("Beren And Luthien", "J.R.R. Tolkien", ItemGenre.FICTION, 1349, 5, 4, "L7", "books/beren.jpg",
                "The tale of Beren and Lúthien was, or became, an essential element in the evolution of The Silmarillion, the myths and legends of the First Age of the World conceived by J.R.R. Tolkien. Returning from France and the battle of the Somme at the end of 1916, he wrote the tale in the following year.\n" +
                        " \n" +
                        "Essential to the story, and never changed, is the fate that shadowed the love of Beren and Lúthien: for Beren was a mortal man, but Lúthien was an immortal elf. Her father, a great elvish lord, in deep opposition to Beren, imposed on him an impossible task that he must perform before he might wed Lúthien. This is the kernel of the legend; and it leads to the supremely heroic attempt of Beren and Lúthien together to rob the greatest of all evil beings, Melkor, called Morgoth, the Black Enemy, of a Silmaril.\n" +
                        " \n" +
                        "In this book Christopher Tolkien has attempted to extract the story of Beren and Lúthien from the comprehensive work in which it was embedded; but that story was itself changing as it developed new associations within the larger history. To show something of the process whereby this legend of Middle-earth evolved over the years, he has told the story in his father's own words by giving, first, its original form, and then passages in prose and verse from later texts that illustrate the narrative as it changed. Presented together for the first time, they reveal aspects of the story, both in event and in narrative immediacy, that were afterwards lost.");
        StoreStorage.getStorage().getShelfMap().put(book70,book70.getItemLocation());

        Book book71 = new Book("Unfinished Tales", "J.R.R. Tolkien", ItemGenre.FICTION, 1513, 5, 3, "L7", "books/unfinishedtale.jpg",
                "Unfinished Tales is a collection of narratives ranging in time from the Elder Days of Middle-earth to the end of the War of the Ring, and provides those who have read The Hobbit and The Lord of the Rings with a whole collection of background and new stories.\n" +
                        "\n" +
                        "The book concentrates on the realm of Middle-earth and comprises such elements as The Quest of Erebor, Gandalf’s lively account of how it was that he came to send the Dwarves to the celebrated party at Bag-End; the emergence of the sea-god Ulmo before the eyes of Tuor on the coast of Beleriand; and an exact description of the military organization of the Riders of Rohan.\n" +
                        "\n" +
                        "Unfinished Tales also contains the only story about the long ages of Númenor before its downfall, and all that is known about such matters as the Five Wizards, the Palantíri and the legend of Amroth. The tales were edited by Christopher Tolkien, who provides a short commentary on each story, helping the reader to fill in the gaps and put each story into the context of the rest of his father’s writings.\n" +
                        "\n" +
                        "In celebration of its 40th anniversary, this jacketed hardcover of Unfinished Tales includes 18 gorgeous paintings depicting scenes from the First, Second, and Third Ages of Middle-earth from critically acclaimed Tolkien artists, Alan Lee, John Howe, and Ted Nasmith.");
        StoreStorage.getStorage().getShelfMap().put(book71,book71.getItemLocation());

        Book book72 = new Book("The Fall of Gondolin", "J.R.R. Tolkien", ItemGenre.FICTION, 993, 5, 5, "L7", "books/fallofgondolin.jpg",
                "Central to this enmity of the gods is the city of Gondolin, beautiful but undiscoverable. It was built and peopled by Noldorin Elves who, when they dwelt in Valinor, the land of the gods, rebelled against their rule and fled to Middle-earth. Turgon King of Gondolin is hated and feared above all his enemies by Morgoth, who seeks in vain to discover the marvellously hidden city, while the gods in Valinor in heated debate largely refuse to intervene in support of Ulmo's desires and designs.\n" +
                        "\n" +
                        "Into this world comes Tuor, cousin of Túrin, the instrument of Ulmo's designs. Guided unseen by him Tuor sets out from the land of his birth on the fearful journey to Gondolin, and in one of the most arresting moments in the history of Middle-earth the sea-god himself appears to him, rising out of the ocean in the midst of a storm. In Gondolin he becomes great; he is wedded to Idril, Turgon's daughter, and their son is Eärendel, whose birth and profound importance in days to come is foreseen by Ulmo.\n" +
                        "\n" +
                        "At last comes the terrible ending. Morgoth learns through an act of supreme treachery all that he needs to mount a devastating attack on the city, with Balrogs and dragons and numberless Orcs. After a minutely observed account of the fall of Gondolin, the tale ends with the escape of Tuor and Idril, with the child Eärendel, looking back from a cleft in the mountains as they flee southward, at the blazing wreckage of their city. They were journeying into a new story, the Tale of Eärendel, which Tolkien never wrote, but which is sketched out in this book from other sources.\n" +
                        "\n" +
                        "Following his presentation of Beren and Lúthien Christopher Tolkien has used the same 'history in sequence' mode in the writing of this edition of The Fall of Gondolin. In the words of J.R.R. Tolkien, it was ‘the first real story of this imaginary world’ and, together with Beren and Lúthien and The Children of Húrin, he regarded it as one of the three 'Great Tales' of the Elder Days.");
        StoreStorage.getStorage().getShelfMap().put(book72,book72.getItemLocation());

        Book book73 = new Book("The Fellowship of the Ring", "J.R.R. Tolkien", ItemGenre.FICTION, 1407, 5, 2, "L7", "books/thefellowship.jpg",
                "The Fellowship of the Ring is the first part of J.R.R. Tolkien’s epic adventure, The Lord of the Rings.\n" +
                        "\n" +
                        "Sauron, the Dark Lord, has gathered to him all the Rings of Power – the means by which he intends to rule Middle-earth. All he lacks in his plans for dominion is the One Ring – the ring that rules them all – which has fallen into the hands of the hobbit, Bilbo Baggins.\n" +
                        "\n" +
                        "In a sleepy village in the Shire, young Frodo Baggins finds himself faced with an immense task, as his elderly cousin Bilbo entrusts the Ring to his care. Frodo must leave his home and make a perilous journey across Middle-earth to the Cracks of Doom, there to destroy the Ring and foil the Dark Lord in his evil purpose.\n" +
                        "\n" +
                        "The text of this edition has been fully corrected and revised in collaboration with Christopher Tolkien and is accompanied by nineteen watercolour paintings from Alan Lee.");
        StoreStorage.getStorage().getShelfMap().put(book73,book73.getItemLocation());

        Book book74 = new Book("The Two Tower", "J.R.R. Tolkien", ItemGenre.FICTION, 1211, 5, 4, "L7", "books/thetwotowers.jpg",
                "The Two Towers is the second part of J.R.R. Tolkien’s epic adventure, The Lord of the Rings.\n" +
                        "\n" +
                        "Frodo and the Companions of the Ring have been beset by danger during their quest to prevent the Ruling Ring from falling into the hands of the Dark Lord by destroying it in the Cracks of Doom. They have lost the wizard, Gandalf, in the battle with an evil spirit in the Mines of Moria; and at the Falls of Rauros, Boromir, seduced by the power of the Ring, tried to seize it by force. While Frodo and Sam made their escape the rest of the company were attacked by Orcs.\n" +
                        "\n" +
                        "Now they continue their journey alone down the great River Anduin – alone, that is, save for the mysterious creeping figure that follows wherever they go.\n" +
                        "\n" +
                        "The text of this edition has been fully corrected and revised in collaboration with Christopher Tolkien and is accompanied by sixteen watercolour paintings from Alan Lee.");
        StoreStorage.getStorage().getShelfMap().put(book74,book74.getItemLocation());

        Book book75 = new Book("Return Of The King", "J.R.R. Tolkien", ItemGenre.FICTION, 1211, 5, 7, "L7", "books/returnoftheking.jpg",
                "The Return of the King is the third part of J.R.R. Tolkien’s epic adventure, The Lord of the Rings.\n" +
                        "\n" +
                        "The Companions of the Ring have become involved in separate adventures as the quest continues. Aragorn, revealed as the hidden heir of the ancient Kings of the West, joined with the Riders of Rohan against the forces of Isengard, and took part in the desperate victory of the Hornburg. Merry and Pippin, captured by orcs, escaped into Fangorn Forest and there encountered the Ents.\n" +
                        "\n" +
                        "Gandalf returned, miraculously, and defeated the evil wizard, Saruman. Meanwhile, Sam and Frodo progressed towards Mordor to destroy the Ring, accompanied by Sméagol–Gollum, still obsessed by his ‘preciouss’. After a battle with the giant spider, Shelob, Sam left his master for dead; but Frodo is still alive – in the hands of the orcs. And all the time the armies of the Dark Lord are massing.\n" +
                        "\n" +
                        "The text of this edition has been fully corrected and revised in collaboration with Christopher Tolkien and is accompanied by fifteen watercolour paintings from Alan Lee.");
        StoreStorage.getStorage().getShelfMap().put(book75,book75.getItemLocation());

//        Book book73 = new Book("", "", ItemGenre.FICTION, 677, 5, 14, "L7", "books/.jpg",
//                "");
//        StoreStorage.getStorage().getShelfMap().put(book73,book73.getItemLocation());





        ///add example books to newArrivalList
        StoreStorage.getStorage().getNewArrivalList().add(book57);
        StoreStorage.getStorage().getNewArrivalList().add(book53);
        StoreStorage.getStorage().getNewArrivalList().add(book61);

        ///add example books to recommendedItemsList
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
        StoreStorage.getStorage().getRecommendedItemsList().add(book15);

    }
}
