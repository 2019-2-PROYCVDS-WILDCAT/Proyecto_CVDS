/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

/**
 *
 * @author AlejandroB
 */
public enum TipoUsuario {
    Comunidad(1),
    Administrador(2);
    private Integer id;
    TipoUsuario(Integer value){
        this.id = value;
    }
    public Integer getId(){
        return id;
    }
    
    public static TipoUsuario fromId(Integer id){
        for (TipoUsuario at : TipoUsuario.values()){
            if (at.getId().equals(id)){
                return at;
            }
        }
        return null;
    }
    public static int getId(String enumTipoUsuario){
        return TipoUsuario.valueOf(enumTipoUsuario).getId();
    }
}
/*
This article is about a fictional book. For other uses, see Necronomicon (disambiguation).
"That is not dead which can eternal lie" redirects here. For the book by Darrell Schweitzer, see That Is Not Dead.

Author H. P. Lovecraft created the Necronomicon as a fictional grimoire and featured it in many of his stories.
The Necronomicon is a fictional grimoire (textbook of magic) appearing in stories by the horror writer H. P. Lovecraft and his followers. It was first mentioned in Lovecraft's 1924 short story "The Hound",[1] written in 1922, though its purported author, the "Mad Arab" Abdul Alhazred, had been quoted a year earlier in Lovecraft's "The Nameless City".[2] Among other things, the work contains an account of the Old Ones, their history, and the means for summoning them.

Other authors such as August Derleth and Clark Ashton Smith also cited it in their works; Lovecraft approved, believing such common allusions built up "a background of evil verisimilitude". Many readers have believed it to be a real work, with booksellers and librarians receiving many requests for it; pranksters have listed it in rare book catalogues, and a student smuggled a card for it into the Yale University Library's card catalog.[3]

Capitalizing on the notoriety of the fictional volume, real-life publishers have printed many books entitled Necronomicon since Lovecraft's death.


Contents
1	Origin
2	Fictional history
3	Appearance and contents
4	Locations
5	Hoaxes and alleged translations
6	In popular culture
7	Commercially available imitations
8	See also
9	References
10	External links
Origin
How Lovecraft conceived the name Necronomicon is not clear—Lovecraft said that the title came to him in a dream.[4] Although some have suggested that Lovecraft was influenced primarily by Robert W. Chambers' collection of short stories The King in Yellow, which centers on a mysterious and disturbing play in book form, Lovecraft is not believed to have read that work until 1927.[5]

Donald R. Burleson has argued that the idea for the book was derived from Nathaniel Hawthorne, though Lovecraft himself noted that "mouldy hidden manuscripts" were one of the stock features of Gothic literature.[6]

Lovecraft wrote[7] that the title, as translated from the Greek language, meant "an image of the law of the dead", compounded respectively from νεκρός nekros "dead", νόμος nomos "law", and εἰκών eikon "image".[8] Robert M. Price notes that the title has been variously translated by others as "Book of the names of the dead", "Book of the laws of the dead", "Book of dead names" and "Knower of the laws of the dead".[citation needed] S. T. Joshi states that Lovecraft's own etymology is "almost entirely unsound. The last portion of it is particularly erroneous, since -ikon is nothing more than a neuter adjectival suffix and has nothing to do with eikõn (image)." Joshi translates the title as "Book considering (or classifying) the dead."[9]

Lovecraft was often asked about the veracity of the Necronomicon, and always answered that it was completely his invention. In a letter to Willis Conover, Lovecraft elaborated upon his typical answer:

Now about the "terrible and forbidden books”—I am forced to say that most of them are purely imaginary. There never was any Abdul Alhazred or Necronomicon, for I invented these names myself. Robert Bloch devised the idea of Ludvig Prinn and his De Vermis Mysteriis, while the Book of Eibon is an invention of Clark Ashton Smith's. Robert E. Howard is responsible for Friedrich von Junzt and his Unaussprechlichen Kulten.... As for seriously-written books on dark, occult, and supernatural themes—in all truth they don’t amount to much. That is why it’s more fun to invent mythical works like the Necronomicon and Book of Eibon.[4]

Reinforcing the book's fictionalization, the name of the book's supposed author, Abdul Alhazred, is not even a grammatically correct Arabic name. "Abdul" means "the worshiper/slave of the", and standing alone it would make no sense, as Alhazred is not a surname in the Western sense, but a reference to a person's place of birth, and its English translation starts with another "the".[10]

Fictional history
In 1927, Lovecraft wrote a brief pseudo-history of the Necronomicon that was published in 1938, after his death, as "History of the Necronomicon". According to this account, the book was originally called Al Azif, an Arabic word that Lovecraft defined as "that nocturnal sound (made by insects) supposed to be the howling of demons", drawing on a footnote by Samuel Henley in Henley's translation of "Vathek".[11] Henley, commenting upon a passage which he translated as "those nocturnal insects which presage evil", alluded to the diabolic legend of Beelzebub, "Lord of the Flies" and to Psalm 91:5, which in some 16th Century English Bibles (such as Myles Coverdale's 1535 translation) describes "bugges by night" where later translations render "terror by night".[12] One Arabic/English dictionary translates `Azīf (عزيف) as "whistling (of the wind); weird sound or noise".[13] Gabriel Oussani defined it as "the eerie sound of the jinn in the wilderness".[14] The tradition of `azif al jinn (عزيف الجن) is linked to the phenomenon of "singing sand".[15]

In the "History", Alhazred is said to have been a "half-crazed Arab" who worshipped the Lovecraftian entities Yog-Sothoth and Cthulhu. He is described as being from Sanaa in Yemen, and as visiting the ruins of Babylon, the "subterranean secrets" of Memphis and the Empty Quarter of Arabia (where he discovered the "nameless city" below Irem). In his last years, he lived in Damascus, where he wrote Al Azif before his sudden and mysterious death in 738.

In subsequent years, Lovecraft wrote, the Azif "gained considerable, though surreptitious circulation amongst the philosophers of the age." In 950, it was translated into Greek and given the title Necronomicon by Theodorus Philetas, a fictional scholar from Constantinople. This version "impelled certain experimenters to terrible attempts" before being "suppressed and burnt" in 1050 by Patriarch Michael (a historical figure who died in 1059).

After this attempted suppression, the work was "only heard of furtively" until it was translated from Greek into Latin by Olaus Wormius. (Lovecraft gives the date of this edition as 1228, though the real-life Danish scholar Olaus Wormius lived from 1588 to 1624.) Both the Latin and Greek text, the "History" relates, were banned by Pope Gregory IX in 1232, though Latin editions were apparently published in 15th century Germany and 17th century Spain. A Greek edition was printed in Italy in the first half of the 16th century.

The Elizabethan magician John Dee (1527-c. 1609) allegedly translated the book—presumably into English—but Lovecraft wrote that this version was never printed and only fragments survive. (The connection between Dee and the Necronomicon was suggested by Lovecraft's friend Frank Belknap Long.)

According to Lovecraft, the Arabic version of Al Azif had already disappeared by the time the Greek version was banned in 1050, though he cites "a vague account of a secret copy appearing in San Francisco during the current [20th] century" that "later perished in fire". The Greek version, he writes, has not been reported "since the burning of a certain Salem man's library in 1692" (an apparent reference to the Salem witch trials). (In the story "The Diary of Alonzo Typer", the character Alonzo Typer finds a Greek copy.)

According to "History of the Necronomicon" the very act of studying the text is inherently dangerous, as those who attempt to master its arcane knowledge generally meet terrible ends.

Appearance and contents
The Necronomicon is mentioned in a number of Lovecraft's short stories and in his novellas At the Mountains of Madness and The Case of Charles Dexter Ward. However, despite frequent references to the book, Lovecraft was very sparing of details about its appearance and contents. He once wrote that "if anyone were to try to write the Necronomicon, it would disappoint all those who have shuddered at cryptic references to it."[16]

In "The Nameless City" (1921), a rhyming couplet that appears at two points in the story is ascribed to Abdul Alhazred:

That is not dead which can eternal lie.
And with strange aeons even death may die.

The same couplet appears in "The Call of Cthulhu" (1928), where it is identified as a quotation from the Necronomicon. This "much-discussed" couplet, as Lovecraft calls it in the latter story, has also been quoted in works by other authors, including Brian Lumley's The Burrowers Beneath, which adds a long paragraph preceding the couplet.

In his story "History of the Necronomicon", Lovecraft states that it is rumored that artist R.U. Pickman (from his story "Pickman's Model") owned a Greek translation of the text, but it vanished along with the artist in early 1926.

The Necronomicon is undoubtedly a substantial text, as indicated by its description in The Dunwich Horror (1929). In the story, Wilbur Whateley visits Miskatonic University's library to consult the "unabridged" version of the Necronomicon for a spell that would have appeared on the 751st page of his own inherited, but defective, Dee edition. The Necronomicon passage in question states:

Nor is it to be thought...that man is either the oldest or the last of earth's masters, or that the common bulk of life and substance walks alone. The Old Ones were, the Old Ones are, and the Old Ones shall be. Not in the spaces we know, but between them, they walk serene and primal, undimensioned and to us unseen. Yog-Sothoth knows the gate. Yog-Sothoth is the gate. Yog-Sothoth is the key and guardian of the gate. Past, present, future, all are one in Yog-Sothoth. He knows where the Old Ones broke through of old, and where They shall break through again. He knows where They had trod earth's fields, and where They still tread them, and why no one can behold Them as They tread. By Their smell can men sometimes know Them near, but of Their semblance can no man know, saving only in the features of those They have begotten on mankind; and of those are there many sorts, differing in likeness from man's truest eidolon to that shape without sight or substance which is Them. They walk unseen and foul in lonely places where the Words have been spoken and the Rites howled through at their Seasons. The wind gibbers with Their voices, and the earth mutters with Their consciousness. They bend the forest and crush the city, yet may not forest or city behold the hand that smites. Kadath in the cold waste hath known Them, and what man knows Kadath? The ice desert of the South and the sunken isles of Ocean hold stones whereon Their seal is engraven, but who hath seen the deep frozen city or the sealed tower long garlanded with seaweed and barnacles? Great Cthulhu is Their cousin, yet can he spy Them only dimly. Iä! Shub-Niggurath! As a foulness shall ye know Them. Their hand is at your throats, yet ye see Them not; and Their habitation is even one with your guarded threshold. Yog-Sothoth is the key to the gate, whereby the spheres meet. Man rules now where They ruled once; They shall soon rule where man rules now. After summer is winter, after winter summer. They wait patient and potent, for here shall They reign again.

The Necronomicon's appearance and physical dimensions are not clearly stated in Lovecraft's work. Other than the obvious black letter editions, it is commonly portrayed as bound in leather of various types and having metal clasps. Moreover, editions are sometimes disguised. In The Case of Charles Dexter Ward, for example, John Merrit pulls down a book labelled Qanoon-e-Islam from Joseph Curwen’s bookshelf and discovers to his disquiet that it is actually the Necronomicon.

Many commercially available versions of the book fail to include any of the contents that Lovecraft describes. The Simon Necronomicon in particular has been criticized for this.[17]

Locations
According to Lovecraft's "History of the Necronomicon", copies of the original Necronomicon were held by only five institutions worldwide:

The British Museum
The Bibliothèque nationale de France
Widener Library of Harvard University in Cambridge, Massachusetts
The University of Buenos Aires
The library of the fictional Miskatonic University in the also fictitious Arkham, Massachusetts
The Miskatonic University also holds the Latin translation by Olaus Wormius, printed in Spain in the 17th century.

Other copies, Lovecraft wrote, were kept by private individuals. Joseph Curwen, as noted, had a copy in The Case of Charles Dexter Ward (1941). A version is held in Kingsport in "The Festival" (1925). The provenance of the copy read by the narrator of "The Nameless City" is unknown; a version is read by the protagonist in "The Hound" (1924).

Hoaxes and alleged translations

A fan-created prop representing the Necronomicon (2004)
Although Lovecraft insisted that the book was pure invention (and other writers invented passages from the book for their own works), there are accounts of some people actually believing the Necronomicon to be a real book. Lovecraft himself sometimes received letters from fans inquiring about the Necronomicon's authenticity. Pranksters occasionally listed the Necronomicon for sale in book store newsletters or inserted phony entries for the book in library card catalogues (where it may be checked out to one 'A. Alhazred', ostensibly the book's author and original owner). The Vatican also receives requests for this book from those who believe the Vatican Library holds a copy.[18]

Similarly, the university library of Tromsø, Norway, lists a translated version of the Necronomicon, attributed to Petrus de Dacia and published in 1994, although the document is listed as "unavailable".[19]

In 1973, Owlswick Press issued an edition of the Necronomicon written in an indecipherable, apparently fictional language known as "Duriac".[20] This was a limited edition of 348. The book contains a brief introduction by L. Sprague de Camp.

The line between fact and fiction was further blurred in the late 1970s when a book purporting to be a translation of "the real" Necronomicon was published. This book, by the pseudonymous "Simon," had little connection to the fictional Lovecraft Mythos but instead was based on Sumerian mythology. It was later dubbed the "Simon Necronomicon". Going into trade paperback in 1980 it has never been out of print and has sold 800,000 copies by 2006 making it the most popular Necronomicon to date.[citation needed] Despite its contents, the book's marketing focused heavily on the Lovecraft connection and made sensational claims for the book's magical power. The blurb states it was "potentially, the most dangerous Black Book known to the Western World". Three additional volumes have since been published — The Necronomicon Spellbook, a book of pathworkings with the 50 names of Marduk; Dead Names: The Dark History of the Necronomicon, a history of the book itself and of the late 1970s New York occult scene; and The Gates Of The Necronomicon, instructions on pathworking with the Simon Necronomicon.[citation needed]

A hoax version of the Necronomicon, edited by George Hay, appeared in 1978 and included an introduction by the paranormal researcher and writer Colin Wilson. David Langford described how the book was prepared from a computer analysis of a discovered "cipher text" by Dr. John Dee. The resulting "translation" was in fact written by occultist Robert Turner, but it was far truer to the Lovecraftian version than the Simon text and even incorporated quotations from Lovecraft's stories in its passages. Wilson also wrote a story, "The Return of the Lloigor", in which the Voynich manuscript turns out to be a copy of the Necronomicon.[21]

With the success of the Simon Necronomicon the controversy surrounding the actual existence of the Necronomicon was such that a detailed book, The Necronomicon Files, was published in 1998 attempting to prove once and for all the book was pure fiction. It covered the well-known Necronomicons in depth, especially the Simon one, along with a number of more obscure ones. It was reprinted and expanded in 2003.[22]

In 2004, Necronomicon: The Wanderings of Alhazred, by Canadian occultist Donald Tyson, was published by Llewellyn Worldwide. The Tyson Necronomicon is generally thought to be closer to Lovecraft's vision than other published versions. Donald Tyson has clearly stated that the Necronomicon is fictional, but that has not prevented his book from being the center of some controversy.[23] Tyson has since published Alhazred, a novelization of the life of the Necronomicon's author.

Kenneth Grant, the British occultist, disciple of Aleister Crowley, and head of the Typhonian Ordo Templi Orientis, suggested in his book The Magical Revival (1972) that there was an unconscious connection between Crowley and Lovecraft. He thought they both drew on the same occult forces; Crowley via his magic and Lovecraft through the dreams which inspired his stories and the Necronomicon. Grant claimed that the Necronomicon existed as an astral book as part of the Akashic records and could be accessed through ritual magic or in dreams. Grant's ideas on Lovecraft were featured heavily in the introduction to the Simon Necronomicon and also have been backed by Tyson.[24]

In popular culture
Main articles: Cthulhu Mythos in popular culture and Lovecraftian horror
The Necronomicon makes minor appearances in many films and television shows and a few video games, and a version of it known as the Necronomicon Ex-Mortis is featured as a primary plot point in the Evil Dead film series.[25][26] This specific version of the Necronomicon then appears briefly in the ninth film of the Friday the 13th franchise, Jason Goes to Hell: The Final Friday.
The Necronomicon appears in the 1991 film, Cast a Deadly Spell, as a "book of esoteric spells" in which the main character, a private eye named H. Phillip Lovecraft, is tasked with locating.
In the 1992 King's Quest VI PC game, the main antagonist is named Abdul Alhazred. However, this is a reference by name only; neither the Cthulhu Mythos nor the Necronomicon makes any appearance in the game.
Necronomicon is a 1994 film anthology of three Lovecraft stories, directed by Brian Yuzna, Christophe Gans and Shusuke Kaneko.
In the 1995 Prisoner of Ice video game, the Necronomicon was used as a weapon to defeat the final boss.
The Necronomicon appears in the comic book Afterlife with Archie.[27]
The Necronomicon appears in the in-character bibliography of Michael Crichton's 1976 novel, Eaters of the Dead.
Philippe Druillet illustrated a version of the Necronomicon in the October 1979 issue of Heavy Metal (September 1978 for the original Métal Hurlant issue).[28][29]
The Necronomicon appears in the video game Crusader Kings II as an artifact the player may obtain.
The Necronomicon can be found in the video game The Binding of Isaac. It can also be found in the sequel,[30] The Binding of Isaac: Rebirth, in which the player can also transform into the Leviathan, whose design is really inspired by Lovecraftian horror.[31]
While not referred to by name, in Stephen King's 1987 novel The Eyes of the Dragon the evil wizard Flagg owns a massive spellbook written by the mad wizard Alhazred in a distant land. To read from this book for too long was to risk madness.
*/