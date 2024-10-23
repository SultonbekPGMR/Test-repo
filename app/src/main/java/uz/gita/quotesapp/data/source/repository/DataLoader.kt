package uz.gita.quotesapp.data.source.repository

import android.util.Log
import uz.gita.quotesapp.R
import uz.gita.quotesapp.data.model.AuthorData
import uz.gita.quotesapp.data.model.CategoryData
import uz.gita.quotesapp.data.model.QuoteData
import uz.gita.quotesapp.data.source.AppDatabase
import uz.gita.quotesapp.data.source.dao.AuthorDao
import uz.gita.quotesapp.data.source.dao.QuoteDao
import uz.gita.quotesapp.data.source.entity.AuthorEntity
import uz.gita.quotesapp.data.source.entity.QuoteEntity

object DataLoader {
    private lateinit var authorList: ArrayList<AuthorData>

    private lateinit var quoteDao: QuoteDao
    private lateinit var authorDao: AuthorDao

    fun loadAllData() {
        quoteDao = AppDatabase.instance.getQuoteDao()
        authorDao = AppDatabase.instance.getAuthorDao()

        authorList = ArrayList()


        loadAuthors()

        lifeQuotes = ArrayList()
        confidenceQuotes = ArrayList()
        motivationalQuotes = ArrayList()
        wisdomQuotes = ArrayList()
        friendshipQuotes = ArrayList()
        happinessQuotes = ArrayList()
        successQuotes = ArrayList()
        perseveranceQuotes = ArrayList()
        courageQuotes = ArrayList()

        loadQuotes()

    }

    private lateinit var lifeQuotes: ArrayList<QuoteData>
    private lateinit var confidenceQuotes: ArrayList<QuoteData>
    private lateinit var motivationalQuotes: ArrayList<QuoteData>
    private lateinit var wisdomQuotes: ArrayList<QuoteData>
    private lateinit var friendshipQuotes: ArrayList<QuoteData>
    private lateinit var happinessQuotes: ArrayList<QuoteData>
    private lateinit var successQuotes: ArrayList<QuoteData>
    private lateinit var perseveranceQuotes: ArrayList<QuoteData>
    private lateinit var courageQuotes: ArrayList<QuoteData>

    private fun loadQuotes() {
        initLifeQuotes()
        insertQuotes(lifeQuotes, "Life")

        initConfidenceQuotes()
        insertQuotes(confidenceQuotes, "Confidence")

        initMotivationalQuotes()
        insertQuotes(motivationalQuotes, "Motivational")

        initWisdomQuotes()
        insertQuotes(wisdomQuotes, "Wisdom")

        initFriendshipQuotes()
        insertQuotes(friendshipQuotes, "Friendship")

        initHappinessQuotes()
        insertQuotes(happinessQuotes, "Happiness")

        initSuccessQuotes()
        insertQuotes(successQuotes, "Success")

        initPerseveranceQuotes()
        insertQuotes(perseveranceQuotes, "Perseverance")

        initCourageQuotes()
        insertQuotes(courageQuotes, "Courage")

    }

    private fun insertQuotes(list: List<QuoteData>, category: String) {

        list.forEach {
            quoteDao.insertQuote(QuoteEntity(0, it.quote, category, 0, it.authorData.index))

        }

    }

    private fun loadAuthors() {
        authorList.add(
            AuthorData(
                0,
                "Nelson Mandela",
                R.drawable.author_nelson,
                "Nelson Mandela was born on July 18, 1918, in Mvezo, South Africa. He was a revolutionary anti-apartheid leader, who became the first Black president of South Africa, serving from 1994 to 1999. Mandela dedicated his life to fighting against racial oppression, advocating for equality and social justice. He was imprisoned for 27 years for his efforts to end apartheid but emerged as a symbol of resilience and hope. His presidency was marked by efforts to reconcile a divided nation. Mandela’s commitment to peace and democracy earned him the Nobel Peace Prize in 1993. Throughout his life, Mandela inspired millions with his messages of forgiveness, courage, and leadership. His autobiography, 'Long Walk to Freedom,' is a testament to his journey of struggle and perseverance. Mandela’s legacy continues to influence global discussions on human rights and equality. He passed away on December 5, 2013, leaving a legacy of change that transcended borders. Mandela's influence extends beyond politics; he was a global symbol of peace, a tireless advocate for human dignity, and a unifying force in the fight for freedom and equality."
            )
        )

        authorList.add(
            AuthorData(
                1,
                "Ralph Waldo",
                R.drawable.author_ralph_waldo,
                "Ralph Waldo Emerson was born on May 25, 1803, in Boston, Massachusetts. He was a renowned American essayist, poet, and philosopher. Emerson led the Transcendentalist movement of the mid-19th century, emphasizing individualism, nature, and self-reliance. His essays, such as 'Self-Reliance' and 'Nature,' encourage people to follow their own path and trust their inner voice. Emerson's lectures and writings had a profound impact on American thought, promoting ideas of spiritual growth and the inherent goodness of humanity. His philosophy championed a life connected to nature and inner reflection. As a mentor to fellow writers like Henry David Thoreau, Emerson's influence extended into various spheres of literature and philosophy. He believed that personal growth and societal progress came from self-reflection and non-conformity. Emerson's ideas continue to resonate in discussions on self-discovery and the pursuit of a meaningful life. He passed away on April 27, 1882, leaving behind a legacy of introspective thought and literary achievement."
            )
        )

        authorList.add(
            AuthorData(
                2,
                "Confucius",
                R.drawable.author_confucius,
                "Confucius, also known as Kong Fuzi, was born in 551 BCE in the Lu state, now part of modern-day China. He was a Chinese philosopher whose teachings laid the foundation for much of Chinese culture and social values. Confucius emphasized morality, the importance of family, respect for elders, and the role of benevolent leadership. His ideas are compiled in the 'Analects,' a collection of sayings and ideas recorded by his disciples. Confucius's philosophy deeply influenced East Asian thought, shaping the social fabric and governance of China for centuries. His concepts of 'Ren' (compassion) and 'Li' (proper conduct) remain central to Confucian ethics. Confucius believed that societal harmony could be achieved through virtue and self-discipline. His teachings continue to influence moral and philosophical discussions worldwide, offering timeless wisdom on leadership and social responsibility. He died in 479 BCE, but his ideas live on as a cornerstone of Eastern philosophy."
            )
        )

        authorList.add(
            AuthorData(
                3,
                "John C. Maxwell",
                R.drawable.author_john_maxweell,
                "John C. Maxwell, born on February 20, 1947, in Garden City, Michigan, is a leadership expert, motivational speaker, and author. He has written over 100 books, many of which focus on leadership, personal development, and growth. His most popular works include 'The 21 Irrefutable Laws of Leadership' and 'Developing the Leader Within You.' Maxwell's teachings emphasize the importance of integrity, influence, and consistent self-improvement for effective leadership. He founded several organizations, including EQUIP and the John Maxwell Company, to train leaders worldwide. His insights have helped shape the practices of leaders in business, education, and government. Maxwell’s influence has extended through his seminars, webinars, and workshops, reaching millions of people globally. He believes that true leadership is measured by the ability to influence others positively. Maxwell continues to inspire people to reach their full potential and make a positive impact in their communities."
            )
        )

        authorList.add(
            AuthorData(
                4,
                "Theodore Roosevelt",
                R.drawable.author_theodore,
                "Theodore Roosevelt, born on October 27, 1858, in New York City, was the 26th President of the United States, serving from 1901 to 1909. Roosevelt was known for his dynamic personality and progressive policies, including the establishment of national parks and efforts to conserve America's natural resources. A strong advocate for 'The Strenuous Life,' he believed in living with energy and purpose. Before his presidency, he served as Governor of New York and Assistant Secretary of the Navy. His foreign policy approach, known as 'Big Stick' diplomacy, emphasized negotiating peacefully while maintaining a strong military. Roosevelt’s accomplishments include the construction of the Panama Canal, trust-busting to regulate big corporations, and winning the Nobel Peace Prize for mediating the Russo-Japanese War. He was a prolific writer and historian, producing books on topics ranging from American history to hunting and wildlife. Roosevelt's legacy as a visionary leader and reformer continues to influence American policy and environmental conservation. He passed away on January 6, 1919."
            )
        )

        authorList.add(
            AuthorData(
                5,
                "Mark Twain",
                R.drawable.author_mark_twain,
                "Mark Twain, born Samuel Clemens on November 30, 1835, in Florida, Missouri, is one of America’s most celebrated writers. Twain’s novels, such as 'The Adventures of Tom Sawyer' and 'Adventures of Huckleberry Finn,' are regarded as classics of American literature. His witty humor and keen observation of human nature made his writings timeless. Twain began his career as a steamboat pilot on the Mississippi River, an experience that profoundly influenced his literary work. He later became a journalist, lecturer, and travel writer, sharing his adventures from around the world. Twain’s writing often satirized societal norms and politics, offering a critical yet humorous perspective on American life in the 19th century. Known for his sharp wit, he delivered many famous quips and aphorisms. Twain’s contributions to literature, storytelling, and social commentary left an enduring legacy. He died on April 21, 1910, but his work continues to be read and admired across the globe."
            )
        )

        authorList.add(
            AuthorData(
                6,
                "Vince Lombardi",
                R.drawable.author_vince,
                "Vince Lombardi was born on June 11, 1913, in Brooklyn, New York. He was a legendary American football coach known for leading the Green Bay Packers to five NFL Championships, including the first two Super Bowl victories. Lombardi’s leadership style emphasized discipline, perseverance, and the relentless pursuit of excellence. His famous motto, 'Winning isn’t everything, it’s the only thing,' reflects his competitive spirit and drive for success. Lombardi's coaching philosophy went beyond the football field, teaching principles of hard work, teamwork, and resilience. He believed in the power of mental toughness and self-discipline, inspiring players and fans alike. His legacy endures not only through the Super Bowl trophy named in his honor but also in the many lives he touched with his inspirational words and steadfast determination. Vince Lombardi passed away on September 3, 1970, but his influence on sports and leadership continues to be felt today."
            )
        )

        authorList.add(
            AuthorData(
                7,
                "Bruce Lee",
                R.drawable.author_bruce_lee,
                "Bruce Lee, born Lee Jun-fan on November 27, 1940, in San Francisco, California, was a martial artist, actor, and philosopher. He is widely regarded as one of the most influential martial artists of all time and a pop culture icon of the 20th century. Bruce Lee's philosophy of martial arts, known as Jeet Kune Do, emphasized flexibility, directness, and the integration of various fighting styles. His famous works include the films 'Enter the Dragon' and 'The Way of the Dragon,' which helped popularize martial arts in the West. Lee believed in the importance of self-expression, encouraging people to be like water, adapting to any situation. Beyond his physical prowess, he was known for his deep thoughts on life, personal growth, and the nature of reality. Bruce Lee’s impact on martial arts, cinema, and popular culture remains significant. He passed away on July 20, 1973, but his legacy continues to inspire martial artists and thinkers worldwide."
            )
        )

        authorList.add(
            AuthorData(
                8,
                "Winston Churchill",
                R.drawable.author_churchill,
                "Winston Churchill was born on November 30, 1874, in Blenheim Palace, England. He was a British statesman, writer, and orator, best known for his leadership as the Prime Minister of the United Kingdom during World War II. Churchill's speeches, filled with resilience and determination, rallied the British people during the darkest days of the war. He famously declared, 'We shall never surrender,' becoming a symbol of British resistance against Nazi Germany. Churchill’s political career spanned over five decades, during which he also served as a soldier, journalist, and historian. His writings, which earned him the Nobel Prize in Literature in 1953, include works like 'A History of the English-Speaking Peoples.' Churchill’s leadership, courage, and wit left an indelible mark on history. He passed away on January 24, 1965,important than knowledge,' reflect his belief in the limitless potential of the human mind. He passed away on April 18, 1955, in Princeton, New Jersey, leaving behind a legacy that has profoundly shaped modern science and our understanding of the universe."
            )
        )



        authorList.add(
            AuthorData(
                9,
                "Mahatma Gandhi",
                R.drawable.author_mahama_magandi,
                "Mahatma Gandhi, born Mohandas Karamchand Gandhi on October 2, 1869, in Porbandar, India, was a leader of the Indian independence movement against British rule. He is known for pioneering the philosophy of nonviolent resistance, or 'Satyagraha,' which inspired civil rights movements worldwide. Gandhi’s commitment to nonviolence and his emphasis on truth and love made him a global symbol of peace. He led campaigns for civil rights, social reform, and the upliftment of the downtrodden, including the Salt March against the British salt monopoly. Gandhi believed in simple living, self-discipline, and the spiritual unity of all people. His teachings emphasized the power of peaceful protest as a means to achieve justice. Despite facing imprisonment and hardships, he remained steadfast in his vision of a free and united India. Gandhi’s influence extends beyond India, as his methods inspired leaders like Martin Luther King Jr. and Nelson Mandela. He was assassinated on January 30, 1948, but his legacy continues to inspire movements for peace and justice."
            )
        )

        authorList.add(
            AuthorData(
                10,
                "C.S. Lewis",
                R.drawable.author_lewis,
                "C.S. Lewis, born Clive Staples Lewis on November 29, 1898, in Belfast, Northern Ireland, was a renowned author, theologian, and scholar. He is best known for his works on Christian apologetics and the beloved 'The Chronicles of Narnia' series. Lewis’s writings, such as 'Mere Christianity' and 'The Screwtape Letters,' explore deep philosophical and spiritual questions with clarity and insight. As a professor at Oxford and later Cambridge University, he was a member of the literary group known as 'The Inklings,' alongside J.R.R. Tolkien. Lewis’s conversion from atheism to Christianity shaped his approach to literature and philosophy, emphasizing themes of morality, faith, and the human experience. His imaginative storytelling combined with profound theological reflections has left a lasting impact on both literature and Christian thought. Lewis passed away on November 22, 1963, but his writings continue to engage readers in exploring the complexities of faith and life."
            )
        )
        authorList.add(
            AuthorData(
                11,
                "Henry David Thoreau",
                R.drawable.author_henry,
                "Henry David Thoreau was born on July 12, 1817, in Concord, Massachusetts. He was an American essayist, poet, and philosopher, known for his transcendentalist views and commitment to simple living. Thoreau's most famous work, 'Walden,' reflects his experiment in living close to nature, finding meaning in solitude and self-reliance. His essay 'Civil Disobedience' has been influential in shaping social and political movements, advocating for the individual's moral duty to resist unjust laws. Thoreau’s philosophy emphasized the importance of nature, individual conscience, and living in harmony with one's values. He believed that true wealth came from a life of simplicity, contemplation, and respect for nature. Thoreau's writings continue to resonate with those seeking a deeper connection to nature and a life of purposeful simplicity. He passed away on May 6, 1862, but his legacy lives on through his timeless reflections on nature, society, and personal freedom."
            )
        )

        authorList.add(
            AuthorData(
                12,
                "William Shakespeare",
                R.drawable.author_william,
                "William Shakespeare, born on April 23, 1564, in Stratford-upon-Avon, England, is widely regarded as one of the greatest playwrights and poets in history. His works, including tragedies like 'Hamlet' and 'Macbeth,' comedies such as 'A Midsummer Night's Dream,' and histories like 'Henry V,' have had a profound influence on English literature and theater. Shakespeare’s mastery of the English language and his understanding of human nature have made his plays timeless. He explored themes of love, power, betrayal, and the complexities of the human condition. His sonnets, filled with rich imagery and deep emotions, continue to be celebrated for their lyrical beauty. Shakespeare’s influence extends beyond the stage, as his words have shaped the English language and inspired countless adaptations across various media. He passed away on April 23, 1616, but his work remains a cornerstone of literary studies and a source of inspiration for artists and writers around the world."
            )
        )

        authorList.add(
            AuthorData(
                13,
                "Henry Ford",
                R.drawable.author_henry_ford,
                "Henry Ford, born on July 30, 1863, in Greenfield Township, Michigan, was an American industrialist and founder of the Ford Motor Company. He revolutionized the automobile industry with the introduction of the assembly line, making cars affordable for the average American. Ford's Model T transformed transportation and ushered in the era of mass production, changing the way people lived and worked. His vision of producing cars efficiently and his commitment to paying fair wages set new standards in industrial practices. Ford believed that economic progress should benefit all, advocating for the idea that 'A business that makes nothing but money is a poor business.' His impact on modern manufacturing and his role in shaping American industry remain significant. Ford’s innovations in the automotive industry made him a global symbol of innovation and progress. He passed away on April 7, 1947, leaving a legacy of technological advancement and a transformed industrial landscape."
            )
        )

        authorList.add(
            AuthorData(
                14,
                "Benjamin Franklin",
                R.drawable.author_franklin,
                "Benjamin Franklin, born on January 17, 1706, in Boston, Massachusetts, was a Founding Father of the United States, a statesman, inventor, writer, and diplomat. He was instrumental in the drafting of the Declaration of Independence and the U.S. Constitution. Franklin's contributions to science and innovation include his experiments with electricity, the invention of the lightning rod, and the development of the Franklin stove. He was also the founder of the first public library in America and played a key role in establishing the University of Pennsylvania. Franklin's writings, including 'Poor Richard's Almanack,' are filled with wit, wisdom, and practical advice. His famous aphorisms, like 'Early to bed and early to rise, makes a man healthy, wealthy, and wise,' reflect his belief in self-discipline and lifelong learning. Franklin’s life embodies the spirit of the American Enlightenment, emphasizing reason, civic responsibility, and curiosity. He passed away on April 17, 1790, leaving a legacy that continues to shape American identity and values."
            )
        )

        authorList.add(
            AuthorData(
                15,
                "John Quincy Adams",
                R.drawable.author_john_adams,
                "John Quincy Adams, born on July 11, 1767, in Braintree, Massachusetts, was the sixth President of the United States and a prominent diplomat and statesman. He was the son of John Adams, the second U.S. President, and served as a key figure in American politics for over five decades. Adams is best known for his diplomatic efforts, including negotiating the Treaty of Ghent, which ended the War of 1812. After his presidency, he served in the House of Representatives, where he became a vocal advocate against slavery. Adams was known for his unwavering principles, including his belief in the importance of education and civic virtue. His famous saying, 'If your actions inspire others to dream more, learn more, do more, and become more, you are a leader,' captures his dedication to inspiring future generations. He passed away on February 23, 1848, in Washington, D.C., leaving a legacy of service, integrity, and dedication to the American republic."
            )
        )

        authorList.add(
            AuthorData(
                16,
                "Michael Jordan",
                R.drawable.author_micheal_jordan,
                "Michael Jordan, born on February 17, 1963, in Brooklyn, New York, is widely regarded as one of the greatest basketball players of all time. He led the Chicago Bulls to six NBA championships during the 1990s and was a two-time Olympic gold medalist. Jordan's incredible athleticism, competitive spirit, and clutch performances earned him the nickname 'Air Jordan' and made him a global icon. He was known for his scoring prowess, defensive skills, and ability to perform under pressure. Jordan’s impact extended beyond the basketball court, as he became a cultural icon and a successful businessman through endorsements and ownership of the Charlotte Hornets. His philosophy of hard work and resilience is encapsulated in his famous saying, 'I've failed over and over and over again in my life. And that is why I succeed.' Jordan's influence continues to inspire athletes and fans around the world, representing the pursuit of excellence and the power of perseverance."
            )
        )

        authorList.add(
            AuthorData(
                17,
                "Albert Einstein",
                R.drawable.author_einstain,
                "Albert Einstein, born on March 14, 1879, in Ulm, Germany, was a theoretical physicist best known for developing the theory of relativity, including the famous equation E=mc². Einstein's groundbreaking work reshaped our understanding of space, time, and the universe. In 1921, he received the Nobel Prize in Physics for his explanation of the photoelectric effect, which laid the foundation for quantum theory. Einstein’s intellectual contributions extended beyond physics; he was a passionate advocate for civil rights and international peace. He fled Nazi Germany in 1933 and settled in the United States, where he continued his research and spoke out against fascism and nuclear proliferation. His writings and lectures explored themes of curiosity, imagination, and the pursuit of knowledge. Einstein's famous sayings, such as 'Imagination is more important than knowledge,' reflect his belief in the limitless potential of the human mind. He passed away on April 18, 1955, in Princeton, New Jersey, leaving behind a legacy that has profoundly shaped modern science and our understanding of the universe."
            )
        )


        authorList.forEach {
            insertAuthor(it)
        }

    }


    private fun insertAuthor(authorData: AuthorData) {
        authorDao.insertAuthor(
            AuthorEntity(
                0,
                authorData.index,
                authorData.name,
                authorData.imageId,
                authorData.detailedInfo
            )
        )
        Log.d("TTTTWWWRRR", "loadAuthor: ")
        for (allAuthor in authorDao.getAllAuthors()) {
            Log.d("TTTTWWWRRR", "loadAuthor: $allAuthor")
        }
    }


    private fun initLifeQuotes() {
        lifeQuotes.add(
            QuoteData(
                1,
                "In the end, it’s not the years in your life that count. It’s the life in your years.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        lifeQuotes.add(
            QuoteData(
                2,
                "Life is what happens when you're busy making other plans.",
                authorList[17]
            )
        ) // Albert Einstein
        lifeQuotes.add(
            QuoteData(
                3,
                "The purpose of our lives is to be happy.",
                authorList[8]
            )
        ) // Winston Churchill
        lifeQuotes.add(
            QuoteData(
                4,
                "Get busy living or get busy dying.",
                authorList[5]
            )
        ) // Mark Twain
        lifeQuotes.add(
            QuoteData(
                5,
                "You only live once, but if you do it right, once is enough.",
                authorList[2]
            )
        ) // Confucius
        lifeQuotes.add(
            QuoteData(
                6,
                "Life is either a daring adventure or nothing at all.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        lifeQuotes.add(
            QuoteData(
                7,
                "Good friends, good books, and a sleepy conscience: this is the ideal life.",
                authorList[16]
            )
        ) // Michael Jordan
        lifeQuotes.add(
            QuoteData(
                8,
                "Life is really simple, but we insist on making it complicated.",
                authorList[0]
            )
        ) // Nelson Mandela
        lifeQuotes.add(
            QuoteData(
                9,
                "The biggest adventure you can take is to live the life of your dreams.",
                authorList[12]
            )
        ) // William Shakespeare
        lifeQuotes.add(
            QuoteData(
                10,
                "Life is short, and it's up to you to make it sweet.",
                authorList[11]
            )
        ) // Henry David Thoreau
        lifeQuotes.add(
            QuoteData(
                11,
                "Life is a succession of lessons which must be lived to be understood.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        lifeQuotes.add(
            QuoteData(
                12,
                "Life is either a daring adventure or nothing at all.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        lifeQuotes.add(
            QuoteData(
                13,
                "Do not dwell in the past, do not dream of the future, concentrate the mind on the present moment.",
                authorList[6]
            )
        ) // Vince Lombardi
        lifeQuotes.add(
            QuoteData(
                14,
                "Life can only be understood backwards; but it must be lived forwards.",
                authorList[3]
            )
        ) // John C. Maxwell
        lifeQuotes.add(
            QuoteData(
                15,
                "The good life is one inspired by love and guided by knowledge.",
                authorList[14]
            )
        ) // Benjamin Franklin
        lifeQuotes.add(
            QuoteData(
                16,
                "Life is what we make it, always has been, always will be.",
                authorList[8]
            )
        ) // Winston Churchill
        lifeQuotes.add(
            QuoteData(
                17,
                "Life isn't about finding yourself. Life is about creating yourself.",
                authorList[5]
            )
        ) // Mark Twain
        lifeQuotes.add(
            QuoteData(
                18,
                "The unexamined life is not worth living.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        lifeQuotes.add(
            QuoteData(
                19,
                "Life is 10% what happens to us and 90% how we react to it.",
                authorList[2]
            )
        ) // Confucius
        lifeQuotes.add(
            QuoteData(
                20,
                "The mind is everything. What you think you become.",
                authorList[0]
            )
        ) // Nelson Mandela
        lifeQuotes.add(
            QuoteData(
                21,
                "The purpose of life is a life of purpose.",
                authorList[11]
            )
        ) // Henry David Thoreau
        lifeQuotes.add(
            QuoteData(
                22,
                "Life is a journey that must be traveled no matter how bad the roads and accommodations.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        lifeQuotes.add(
            QuoteData(
                23,
                "Live in the sunshine, swim in the sea, drink the wild air.",
                authorList[16]
            )
        ) // Michael Jordan
        lifeQuotes.add(
            QuoteData(
                24,
                "Life is like riding a bicycle. To keep your balance, you must keep moving.",
                authorList[17]
            )
        ) // Albert Einstein
        lifeQuotes.add(
            QuoteData(
                25,
                "Success is how high you bounce when you hit bottom.",
                authorList[5]
            )
        )
    }


    private fun initConfidenceQuotes() {
        confidenceQuotes.add(
            QuoteData(
                1,
                "Believe you can and you're halfway there.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        confidenceQuotes.add(
            QuoteData(
                2,
                "Confidence comes not from always being right but from not fearing to be wrong.",
                authorList[6]
            )
        ) // Vince Lombardi
        confidenceQuotes.add(
            QuoteData(
                3,
                "With confidence, you have won before you have started.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        confidenceQuotes.add(
            QuoteData(
                4,
                "Self-confidence is the first requisite to great undertakings.",
                authorList[0]
            )
        ) // Nelson Mandela
        confidenceQuotes.add(
            QuoteData(
                5,
                "Optimism is the faith that leads to achievement. Nothing can be done without hope and confidence.",
                authorList[8]
            )
        ) // Winston Churchill
        confidenceQuotes.add(
            QuoteData(
                6,
                "Confidence is preparation. Everything else is beyond your control.",
                authorList[17]
            )
        ) // Albert Einstein
        confidenceQuotes.add(
            QuoteData(
                7,
                "The most beautiful thing you can wear is confidence.",
                authorList[5]
            )
        ) // Mark Twain
        confidenceQuotes.add(
            QuoteData(
                8,
                "To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment.",
                authorList[12]
            )
        ) // William Shakespeare
        confidenceQuotes.add(
            QuoteData(
                9,
                "Your success will be determined by your own confidence and fortitude.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        confidenceQuotes.add(
            QuoteData(
                10,
                "Confidence is not a guarantee of success, but a pattern of thinking that will improve your likelihood of success.",
                authorList[14]
            )
        ) // Benjamin Franklin
        confidenceQuotes.add(
            QuoteData(
                11,
                "Confidence is contagious. So is lack of confidence.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        confidenceQuotes.add(
            QuoteData(
                12,
                "Do what you can, with what you have, where you are.",
                authorList[2]
            )
        ) // Confucius
        confidenceQuotes.add(
            QuoteData(
                13,
                "Success is not how high you have climbed, but how you make a positive difference to the world.",
                authorList[8]
            )
        ) // Winston Churchill
        confidenceQuotes.add(
            QuoteData(
                14,
                "Success usually comes to those who are too busy to be looking for it.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        confidenceQuotes.add(
            QuoteData(
                15,
                "Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle.",
                authorList[6]
            )
        ) // Vince Lombardi
        confidenceQuotes.add(
            QuoteData(
                16,
                "Act as if what you do makes a difference. It does.",
                authorList[0]
            )
        ) // Nelson Mandela
        confidenceQuotes.add(
            QuoteData(
                17,
                "It is confidence in our bodies, minds, and spirits that allows us to keep looking for new adventures.",
                authorList[17]
            )
        ) // Albert Einstein
        confidenceQuotes.add(
            QuoteData(
                18,
                "The most difficult thing is the decision to act; the rest is merely tenacity.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        confidenceQuotes.add(
            QuoteData(
                19,
                "Confidence is the key to unlocking your potential.",
                authorList[11]
            )
        ) // Henry David Thoreau
        confidenceQuotes.add(
            QuoteData(
                20,
                "To succeed in life, you need three things: a wishbone, a backbone, and a funny bone.",
                authorList[12]
            )
        ) // William Shakespeare
        confidenceQuotes.add(
            QuoteData(
                21,
                "Success is not in what you have, but who you are.",
                authorList[6]
            )
        ) // Vince Lombardi
        confidenceQuotes.add(
            QuoteData(
                22,
                "The only limit to our realization of tomorrow will be our doubts of today.",
                authorList[14]
            )
        ) // Benjamin Franklin
        confidenceQuotes.add(
            QuoteData(
                23,
                "You gain strength, courage, and confidence by every experience in which you really stop to look fear in the face.",
                authorList[2]
            )
        ) // Confucius
        confidenceQuotes.add(
            QuoteData(
                24,
                "Don't watch the clock; do what it does. Keep going.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        confidenceQuotes.add(
            QuoteData(
                25,
                "Keep your face always toward the sunshine—and shadows will fall behind you.",
                authorList[4]
            )
        ) // Theodore Roosevelt
    }


    private fun initMotivationalQuotes() {
        motivationalQuotes.add(
            QuoteData(
                1,
                "The future belongs to those who believe in the beauty of their dreams.",
                authorList[8]
            )
        ) // Winston Churchill
        motivationalQuotes.add(
            QuoteData(
                2,
                "It always seems impossible until it's done.",
                authorList[17]
            )
        ) // Albert Einstein
        motivationalQuotes.add(
            QuoteData(
                3,
                "What you get by achieving your goals is not as important as what you become by achieving your goals.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        motivationalQuotes.add(
            QuoteData(
                4,
                "The only way to do great work is to love what you do.",
                authorList[6]
            )
        ) // Vince Lombardi
        motivationalQuotes.add(
            QuoteData(
                5,
                "Don't be pushed around by the fears in your mind. Be led by the dreams in your heart.",
                authorList[0]
            )
        ) // Nelson Mandela
        motivationalQuotes.add(
            QuoteData(
                6,
                "Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle.",
                authorList[6]
            )
        ) // Vince Lombardi
        motivationalQuotes.add(
            QuoteData(
                7,
                "The only limit to our realization of tomorrow will be our doubts of today.",
                authorList[14]
            )
        ) // Benjamin Franklin
        motivationalQuotes.add(
            QuoteData(
                8,
                "You are never too old to set another goal or to dream a new dream.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        motivationalQuotes.add(
            QuoteData(
                9,
                "Success is not final, failure is not fatal: It is the courage to continue that counts.",
                authorList[17]
            )
        ) // Albert Einstein
        motivationalQuotes.add(
            QuoteData(
                10,
                "Hardships often prepare ordinary people for an extraordinary destiny.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        motivationalQuotes.add(
            QuoteData(
                11,
                "Success usually comes to those who are too busy to be looking for it.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        motivationalQuotes.add(
            QuoteData(
                12,
                "If you can dream it, you can do it.",
                authorList[8]
            )
        ) // Winston Churchill
        motivationalQuotes.add(
            QuoteData(
                13,
                "Success is how high you bounce when you hit bottom.",
                authorList[5]
            )
        ) // Mark Twain
        motivationalQuotes.add(
            QuoteData(
                14,
                "Keep your face always toward the sunshine—and shadows will fall behind you.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        motivationalQuotes.add(
            QuoteData(
                15,
                "The secret of success is to be ready when your opportunity comes.",
                authorList[3]
            )
        ) // John C. Maxwell
        motivationalQuotes.add(
            QuoteData(
                16,
                "You miss 100% of the shots you don't take.",
                authorList[12]
            )
        ) // William Shakespeare
        motivationalQuotes.add(
            QuoteData(
                17,
                "Dream big and dare to fail.",
                authorList[2]
            )
        ) // Confucius
        motivationalQuotes.add(
            QuoteData(
                18,
                "Opportunities don't happen. You create them.",
                authorList[8]
            )
        ) // Winston Churchill
        motivationalQuotes.add(
            QuoteData(
                19,
                "The only way to achieve the impossible is to believe it is possible.",
                authorList[0]
            )
        ) // Nelson Mandela
        motivationalQuotes.add(
            QuoteData(
                20,
                "Act as if what you do makes a difference. It does.",
                authorList[14]
            )
        ) // Benjamin Franklin
        motivationalQuotes.add(
            QuoteData(
                21,
                "Your limitation—it's only your imagination.",
                authorList[17]
            )
        ) // Albert Einstein
        motivationalQuotes.add(
            QuoteData(
                22,
                "Push yourself, because no one else is going to do it for you.",
                authorList[6]
            )
        ) // Vince Lombardi
        motivationalQuotes.add(
            QuoteData(
                23,
                "Great things never come from comfort zones.",
                authorList[11]
            )
        ) // Henry David Thoreau
        motivationalQuotes.add(
            QuoteData(
                24,
                "Dream it. Wish it. Do it.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        motivationalQuotes.add(
            QuoteData(
                25,
                "The difference between a successful person and others is not a lack of strength, not a lack of knowledge, but rather a lack in will.",
                authorList[9]
            )
        ) // Mahatma Gandhi
    }

    private fun initWisdomQuotes() {
        wisdomQuotes.add(
            QuoteData(
                1,
                "The only true wisdom is in knowing you know nothing.",
                authorList[2]
            )
        ) // Confucius
        wisdomQuotes.add(
            QuoteData(
                2,
                "In seeking wisdom, we must first forget all the prejudices we have been taught.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        wisdomQuotes.add(
            QuoteData(
                3,
                "Knowing yourself is the beginning of all wisdom.",
                authorList[17]
            )
        ) // Albert Einstein
        wisdomQuotes.add(QuoteData(4, "Wisdom begins in wonder.", authorList[0])) // Nelson Mandela
        wisdomQuotes.add(
            QuoteData(
                5,
                "To know what you know and what you do not know, that is true knowledge.",
                authorList[8]
            )
        ) // Winston Churchill
        wisdomQuotes.add(
            QuoteData(
                6,
                "It is the mark of an educated mind to be able to entertain a thought without accepting it.",
                authorList[5]
            )
        ) // Mark Twain
        wisdomQuotes.add(
            QuoteData(
                7,
                "Wisdom is the reward you get for a lifetime of listening when you'd have preferred to talk.",
                authorList[6]
            )
        ) // Vince Lombardi
        wisdomQuotes.add(
            QuoteData(
                8,
                "Patience is the companion of wisdom.",
                authorList[3]
            )
        ) // John C. Maxwell
        wisdomQuotes.add(
            QuoteData(
                9,
                "The wise man does not lay up his own treasures. The more he gives to others, the more he has for himself.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        wisdomQuotes.add(
            QuoteData(
                10,
                "A wise man will make more opportunities than he finds.",
                authorList[14]
            )
        ) // Benjamin Franklin
        wisdomQuotes.add(
            QuoteData(
                11,
                "Do not dwell in the past, do not dream of the future, concentrate the mind on the present moment.",
                authorList[17]
            )
        ) // Albert Einstein
        wisdomQuotes.add(
            QuoteData(
                12,
                "The only limit to our realization of tomorrow is our doubts of today.",
                authorList[2]
            )
        ) // Confucius
        wisdomQuotes.add(
            QuoteData(
                13,
                "Wisdom is not a product of schooling but of the lifelong attempt to acquire it.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        wisdomQuotes.add(
            QuoteData(
                14,
                "The more that you read, the more things you will know. The more that you learn, the more places you'll go.",
                authorList[12]
            )
        ) // William Shakespeare
        wisdomQuotes.add(
            QuoteData(
                15,
                "A fool thinks himself to be wise, but a wise man knows himself to be a fool.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        wisdomQuotes.add(
            QuoteData(
                16,
                "Life can only be understood backwards; but it must be lived forwards.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        wisdomQuotes.add(
            QuoteData(
                17,
                "In every walk with nature one receives far more than he seeks.",
                authorList[3]
            )
        ) // John C. Maxwell
        wisdomQuotes.add(
            QuoteData(
                18,
                "Knowledge speaks, but wisdom listens.",
                authorList[11]
            )
        ) // Henry David Thoreau
        wisdomQuotes.add(
            QuoteData(
                19,
                "The only thing that interferes with my learning is my education.",
                authorList[17]
            )
        ) // Albert Einstein
        wisdomQuotes.add(
            QuoteData(
                20,
                "What we learn with pleasure we never forget.",
                authorList[14]
            )
        ) // Benjamin Franklin
        wisdomQuotes.add(
            QuoteData(
                21,
                "Your life is what your thoughts make it.",
                authorList[5]
            )
        ) // Mark Twain
        wisdomQuotes.add(
            QuoteData(
                22,
                "Knowing others is intelligence; knowing yourself is true wisdom.",
                authorList[6]
            )
        ) // Vince Lombardi
        wisdomQuotes.add(
            QuoteData(
                23,
                "The journey of a thousand miles begins with one step.",
                authorList[0]
            )
        ) // Nelson Mandela
        wisdomQuotes.add(
            QuoteData(
                24,
                "The greatest wisdom is in simplicity.",
                authorList[8]
            )
        ) // Winston Churchill
        wisdomQuotes.add(
            QuoteData(
                25,
                "An investment in knowledge always pays the best interest.",
                authorList[14]
            )
        ) // Benjamin Franklin
    }

    private fun initFriendshipQuotes() {
        friendshipQuotes.add(
            QuoteData(
                1,
                "A friend is someone who knows all about you and still loves you.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        friendshipQuotes.add(
            QuoteData(
                2,
                "Friendship is born at that moment when one person says to another, 'What! You too? I thought I was the only one.'",
                authorList[12]
            )
        ) // William Shakespeare
        friendshipQuotes.add(
            QuoteData(
                3,
                "True friendship comes when the silence between two people is comfortable.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        friendshipQuotes.add(
            QuoteData(
                4,
                "Friends are the family we choose for ourselves.",
                authorList[0]
            )
        ) // Nelson Mandela
        friendshipQuotes.add(
            QuoteData(
                5,
                "A single rose can be my garden... a single friend, my world.",
                authorList[8]
            )
        ) // Winston Churchill
        friendshipQuotes.add(
            QuoteData(
                6,
                "Friendship improves happiness and abates misery, by the doubling of our joy and the dividing of our grief.",
                authorList[3]
            )
        ) // John C. Maxwell
        friendshipQuotes.add(
            QuoteData(
                7,
                "The only way to have a friend is to be one.",
                authorList[6]
            )
        ) // Vince Lombardi
        friendshipQuotes.add(
            QuoteData(
                8,
                "There are no strangers here; only friends you haven't yet met.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        friendshipQuotes.add(
            QuoteData(
                9,
                "A real friend is one who walks in when the rest of the world walks out.",
                authorList[5]
            )
        ) // Mark Twain
        friendshipQuotes.add(
            QuoteData(
                10,
                "The language of friendship is not words but meanings.",
                authorList[17]
            )
        ) // Albert Einstein
        friendshipQuotes.add(
            QuoteData(
                11,
                "Friendship is the only cement that will ever hold the world together.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        friendshipQuotes.add(
            QuoteData(
                12,
                "In the end, we will remember not the words of our enemies, but the silence of our friends.",
                authorList[2]
            )
        ) // Confucius
        friendshipQuotes.add(
            QuoteData(
                13,
                "A true friend is someone who is there for you when he'd rather be anywhere else.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        friendshipQuotes.add(
            QuoteData(
                14,
                "Friends show their love in times of trouble, not in happiness.",
                authorList[17]
            )
        ) // Albert Einstein
        friendshipQuotes.add(
            QuoteData(
                15,
                "It is one of the blessings of old friends that you can afford to be stupid with them.",
                authorList[3]
            )
        ) // John C. Maxwell
        friendshipQuotes.add(
            QuoteData(
                16,
                "The greatest gift of life is friendship, and I have received it.",
                authorList[0]
            )
        ) // Nelson Mandela
        friendshipQuotes.add(
            QuoteData(
                17,
                "A friend is what the heart needs all the time.",
                authorList[5]
            )
        ) // Mark Twain
        friendshipQuotes.add(
            QuoteData(
                18,
                "A good friend can tell you what is the matter with you in a minute. He may not seem profound, but he is.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        friendshipQuotes.add(
            QuoteData(
                19,
                "True friendship is like sound health; the value of it is seldom known until it is lost.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        friendshipQuotes.add(
            QuoteData(
                20,
                "The best way to predict your future is to create it with your friends.",
                authorList[2]
            )
        ) // Confucius
        friendshipQuotes.add(
            QuoteData(
                21,
                "Friendship is always a sweet responsibility, never an opportunity.",
                authorList[14]
            )
        ) // Benjamin Franklin
        friendshipQuotes.add(
            QuoteData(
                22,
                "The most beautiful discovery true friends make is that they can grow separately without growing apart.",
                authorList[6]
            )
        ) // Vince Lombardi
        friendshipQuotes.add(
            QuoteData(
                23,
                "A friend is someone who gives you total freedom to be yourself.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        friendshipQuotes.add(
            QuoteData(
                24,
                "The only thing better than having you as my friend is my kids having you as their aunt.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        friendshipQuotes.add(
            QuoteData(
                25,
                "Friendship improves happiness and abates misery, by the doubling of our joy and the dividing of our grief.",
                authorList[12]
            )
        ) // William Shakespeare
    }

    private fun initHappinessQuotes() {
        happinessQuotes.add(
            QuoteData(
                1,
                "Happiness is not something ready made. It comes from your own actions.",
                authorList[3]
            )
        ) // John C. Maxwell
        happinessQuotes.add(
            QuoteData(
                2,
                "For every minute you are angry, you lose sixty seconds of happiness.",
                authorList[17]
            )
        ) // Albert Einstein
        happinessQuotes.add(
            QuoteData(
                3,
                "The best way to cheer yourself is to try to cheer someone else up.",
                authorList[0]
            )
        ) // Nelson Mandela
        happinessQuotes.add(
            QuoteData(
                4,
                "Happiness is a warm puppy.",
                authorList[14]
            )
        ) // Benjamin Franklin
        happinessQuotes.add(
            QuoteData(
                5,
                "Happiness is not a goal; it is a by-product.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        happinessQuotes.add(
            QuoteData(
                6,
                "The most important thing is to enjoy your life—to be happy—it’s all that matters.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        happinessQuotes.add(
            QuoteData(
                7,
                "Happiness depends upon ourselves.",
                authorList[2]
            )
        ) // Confucius
        happinessQuotes.add(
            QuoteData(
                8,
                "Count your age by friends, not years. Count your life by smiles, not tears.",
                authorList[5]
            )
        ) // Mark Twain
        happinessQuotes.add(
            QuoteData(
                9,
                "The purpose of our lives is to be happy.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        happinessQuotes.add(
            QuoteData(
                10,
                "Success is getting what you want. Happiness is wanting what you get.",
                authorList[17]
            )
        ) // Albert Einstein
        happinessQuotes.add(
            QuoteData(
                11,
                "Happiness is not a destination. It is a way of life.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        happinessQuotes.add(
            QuoteData(
                12,
                "There is only one happiness in this life, to love and be loved.",
                authorList[6]
            )
        ) // Vince Lombardi
        happinessQuotes.add(
            QuoteData(
                13,
                "The happiest people do not have the best of everything; they make the best of everything.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        happinessQuotes.add(
            QuoteData(
                14,
                "Happiness often sneaks in through a door you didn’t know you left open.",
                authorList[14]
            )
        ) // Benjamin Franklin
        happinessQuotes.add(
            QuoteData(
                15,
                "To be happy, we must not be too concerned with others.",
                authorList[3]
            )
        ) // John C. Maxwell
        happinessQuotes.add(
            QuoteData(
                16,
                "Happiness is a direction, not a place.",
                authorList[2]
            )
        ) // Confucius
        happinessQuotes.add(
            QuoteData(
                17,
                "The key to happiness is low expectations.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        happinessQuotes.add(
            QuoteData(
                18,
                "The only way to find true happiness is to risk being completely cut open.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        happinessQuotes.add(
            QuoteData(
                19,
                "Happiness is when what you think, what you say, and what you do are in harmony.",
                authorList[0]
            )
        ) // Nelson Mandela
        happinessQuotes.add(
            QuoteData(
                20,
                "Happiness is not by chance, but by choice.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        happinessQuotes.add(
            QuoteData(
                21,
                "We don't stop playing because we grow old; we grow old because we stop playing.",
                authorList[5]
            )
        ) // Mark Twain
        happinessQuotes.add(
            QuoteData(
                22,
                "The purpose of life is to live it, to taste experience to the utmost, to reach out eagerly and without fear for newer and richer experience.",
                authorList[14]
            )
        ) // Benjamin Franklin
        happinessQuotes.add(
            QuoteData(
                23,
                "The greatest pleasure in life is doing what people say you cannot do.",
                authorList[12]
            )
        ) // William Shakespeare
        happinessQuotes.add(
            QuoteData(
                24,
                "Happiness is a choice, and it is not always an easy one.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        happinessQuotes.add(
            QuoteData(
                25,
                "Happiness is letting go of what you think your life is supposed to look like.",
                authorList[3]
            )
        ) // John C. Maxwell
    }

    private fun initSuccessQuotes() {
        successQuotes.add(
            QuoteData(
                1,
                "Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        successQuotes.add(
            QuoteData(
                2,
                "Success is how high you bounce when you hit bottom.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        successQuotes.add(
            QuoteData(
                3,
                "I find that the harder I work, the more luck I seem to have.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        successQuotes.add(
            QuoteData(
                4,
                "The successful warrior is the average man, with laser-like focus.",
                authorList[6]
            )
        ) // Vince Lombardi
        successQuotes.add(
            QuoteData(
                5,
                "Success is not in what you have, but who you are.",
                authorList[2]
            )
        ) // Confucius
        successQuotes.add(
            QuoteData(
                6,
                "Success is to be measured not so much by the position that one has reached in life as by the obstacles which he has overcome.",
                authorList[5]
            )
        ) // Mark Twain
        successQuotes.add(
            QuoteData(
                7,
                "The road to success and the road to failure are almost exactly the same.",
                authorList[14]
            )
        ) // Benjamin Franklin
        successQuotes.add(
            QuoteData(
                8,
                "Success usually comes to those who are too busy to be looking for it.",
                authorList[0]
            )
        ) // Nelson Mandela
        successQuotes.add(
            QuoteData(
                9,
                "Success is not the result of spontaneous combustion. You must set yourself on fire.",
                authorList[3]
            )
        ) // John C. Maxwell
        successQuotes.add(
            QuoteData(
                10,
                "What is success? It is being able to go to bed each night with your soul at peace.",
                authorList[17]
            )
        ) // Albert Einstein
        successQuotes.add(
            QuoteData(
                11,
                "Success is liking yourself, liking what you do, and liking how you do it.",
                authorList[12]
            )
        ) // William Shakespeare
        successQuotes.add(
            QuoteData(
                12,
                "Success is the sum of small efforts, repeated day in and day out.",
                authorList[6]
            )
        ) // Vince Lombardi
        successQuotes.add(
            QuoteData(
                13,
                "There are no limits to what you can accomplish, except the limits you place on your own thinking.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        successQuotes.add(
            QuoteData(
                14,
                "You may be disappointed if you fail, but you are doomed if you don't try.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        successQuotes.add(
            QuoteData(
                15,
                "Success is not a destination, but the road that you're on.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        successQuotes.add(
            QuoteData(
                16,
                "The greatest glory in living lies not in never falling, but in rising every time we fall.",
                authorList[5]
            )
        ) // Mark Twain
        successQuotes.add(
            QuoteData(
                17,
                "Don't watch the clock; do what it does. Keep going.",
                authorList[3]
            )
        ) // John C. Maxwell
        successQuotes.add(
            QuoteData(
                18,
                "Success is getting what you want. Happiness is wanting what you get.",
                authorList[17]
            )
        ) // Albert Einstein
        successQuotes.add(
            QuoteData(
                19,
                "Success is the ability to go from one failure to another with no loss of enthusiasm.",
                authorList[12]
            )
        ) // Winston Churchill
        successQuotes.add(
            QuoteData(
                20,
                "The secret of success is to be ready when your opportunity comes.",
                authorList[2]
            )
        ) // Confucius
        successQuotes.add(
            QuoteData(
                21,
                "Success is not about how much money you make, but about the difference you make in people's lives.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        successQuotes.add(
            QuoteData(
                22,
                "The only place where success comes before work is in the dictionary.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        successQuotes.add(
            QuoteData(
                23,
                "Success is to be measured not so much by the position that one has reached in life as by the obstacles which he has overcome.",
                authorList[0]
            )
        ) // Nelson Mandela
        successQuotes.add(
            QuoteData(
                24,
                "Your time is limited, don't waste it living someone else's life.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        successQuotes.add(
            QuoteData(
                25,
                "Success is not final, failure is not fatal: It is the courage to continue that counts.",
                authorList[12]
            )
        ) // Winston Churchill
    }


    private fun initCourageQuotes() {
        courageQuotes.add(
            QuoteData(
                1,
                "Courage is not the absence of fear, but the triumph over it.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        courageQuotes.add(
            QuoteData(
                2,
                "It takes courage to grow up and become who you really are.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        courageQuotes.add(
            QuoteData(
                3,
                "Courage is grace under pressure.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        courageQuotes.add(
            QuoteData(
                4,
                "You cannot swim for new horizons until you have courage to lose sight of the shore.",
                authorList[3]
            )
        ) // John C. Maxwell
        courageQuotes.add(
            QuoteData(
                5,
                "Courage is resistance to fear, mastery of fear, not absence of fear.",
                authorList[12]
            )
        ) // Mark Twain
        courageQuotes.add(
            QuoteData(
                6,
                "The only thing we have to fear is fear itself.",
                authorList[0]
            )
        ) // Nelson Mandela
        courageQuotes.add(
            QuoteData(
                7,
                "Courage is not the absence of fear, but rather the assessment that something else is more important than fear.",
                authorList[2]
            )
        ) // Confucius
        courageQuotes.add(
            QuoteData(
                8,
                "The brave man is not he who does not feel afraid, but he who conquers that fear.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        courageQuotes.add(
            QuoteData(
                9,
                "Success is not final, failure is not fatal: it is the courage to continue that counts.",
                authorList[12]
            )
        ) // Winston Churchill
        courageQuotes.add(
            QuoteData(
                10,
                "Life shrinks or expands in proportion to one's courage.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        courageQuotes.add(
            QuoteData(
                11,
                "Courage is the first of human qualities because it is the quality which guarantees all others.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        courageQuotes.add(
            QuoteData(
                12,
                "In the end, we will remember not the words of our enemies, but the silence of our friends.",
                authorList[6]
            )
        ) // Vince Lombardi
        courageQuotes.add(
            QuoteData(
                13,
                "Fortune favors the brave.",
                authorList[0]
            )
        ) // Nelson Mandela
        courageQuotes.add(
            QuoteData(
                14,
                "You have to be brave with your life so others can be brave with theirs.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        courageQuotes.add(
            QuoteData(
                15,
                "Courage is knowing what not to fear.",
                authorList[3]
            )
        ) // John C. Maxwell
        courageQuotes.add(
            QuoteData(
                16,
                "All our dreams can come true if we have the courage to pursue them.",
                authorList[2]
            )
        ) // Confucius
        courageQuotes.add(
            QuoteData(
                17,
                "The greatest glory in living lies not in never falling, but in rising every time we fall.",
                authorList[17]
            )
        ) // Albert Einstein
        courageQuotes.add(
            QuoteData(
                18,
                "What we fear doing most is usually what we most need to do.",
                authorList[5]
            )
        ) // Mark Twain
        courageQuotes.add(
            QuoteData(
                19,
                "Bravery is being the only one who knows you're afraid.",
                authorList[14]
            )
        ) // Benjamin Franklin
        courageQuotes.add(
            QuoteData(
                20,
                "Courage is not the absence of fear, but the determination to act in spite of fear.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        courageQuotes.add(
            QuoteData(
                21,
                "You can't be brave if you've only had wonderful things happen to you.",
                authorList[6]
            )
        ) // Vince Lombardi
        courageQuotes.add(
            QuoteData(
                22,
                "Courage is being scared to death, but saddling up anyway.",
                authorList[0]
            )
        ) // Nelson Mandela
        courageQuotes.add(
            QuoteData(
                23,
                "It is not enough to be brave. You must be brave for something.",
                authorList[2]
            )
        ) // Confucius
        courageQuotes.add(
            QuoteData(
                24,
                "Take risks: if you win, you will be happy; if you lose, you will be wise.",
                authorList[12]
            )
        ) // Winston Churchill
        courageQuotes.add(
            QuoteData(
                25,
                "The only way to achieve the impossible is to believe it is possible.",
                authorList[3]
            )
        ) // John C. Maxwell
    }


    private fun initPerseveranceQuotes() {
        perseveranceQuotes.add(
            QuoteData(
                1,
                "Perseverance is not a long race; it is many short races one after the other.",
                authorList[12]
            )
        ) // William Shakespeare
        perseveranceQuotes.add(
            QuoteData(
                2,
                "It does not matter how slowly you go as long as you do not stop.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        perseveranceQuotes.add(
            QuoteData(
                3,
                "Success is not final, failure is not fatal: It is the courage to continue that counts.",
                authorList[8]
            )
        ) // Winston Churchill
        perseveranceQuotes.add(
            QuoteData(
                4,
                "Fall seven times, stand up eight.",
                authorList[17]
            )
        ) // Albert Einstein
        perseveranceQuotes.add(
            QuoteData(
                5,
                "The difference between a successful person and others is not a lack of strength, not a lack of knowledge, but rather a lack in will.",
                authorList[0]
            )
        ) // Nelson Mandela
        perseveranceQuotes.add(
            QuoteData(
                6,
                "The only limit to our realization of tomorrow will be our doubts of today.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        perseveranceQuotes.add(
            QuoteData(
                7,
                "Many of life's failures are people who did not realize how close they were to success when they gave up.",
                authorList[16]
            )
        ) // Michael Jordan
        perseveranceQuotes.add(
            QuoteData(
                8,
                "Keep going. Each step may get harder, but don't stop. The view at the top is beautiful.",
                authorList[3]
            )
        ) // John C. Maxwell
        perseveranceQuotes.add(
            QuoteData(
                9,
                "Perseverance is failing 19 times and succeeding the 20th.",
                authorList[5]
            )
        ) // Mark Twain
        perseveranceQuotes.add(
            QuoteData(
                10,
                "The road to success is dotted with many tempting parking spaces.",
                authorList[6]
            )
        ) // Vince Lombardi
        perseveranceQuotes.add(
            QuoteData(
                11,
                "Success is not the result of spontaneous combustion. You must set yourself on fire.",
                authorList[17]
            )
        ) // Albert Einstein
        perseveranceQuotes.add(
            QuoteData(
                12,
                "Our greatest glory is not in never falling, but in rising every time we fall.",
                authorList[3]
            )
        ) // John C. Maxwell
        perseveranceQuotes.add(
            QuoteData(
                13,
                "Patience and perseverance have a magical effect before which difficulties disappear and obstacles vanish.",
                authorList[9]
            )
        ) // Mahatma Gandhi
        perseveranceQuotes.add(
            QuoteData(
                14,
                "If you're going through hell, keep going.",
                authorList[8]
            )
        ) // Winston Churchill
        perseveranceQuotes.add(
            QuoteData(
                15,
                "Great works are performed not by strength but by perseverance.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        perseveranceQuotes.add(
            QuoteData(
                16,
                "The secret of our success is that we never, never give up.",
                authorList[6]
            )
        ) // Vince Lombardi
        perseveranceQuotes.add(
            QuoteData(
                17,
                "Success is stumbling from failure to failure with no loss of enthusiasm.",
                authorList[1]
            )
        ) // Ralph Waldo Emerson
        perseveranceQuotes.add(
            QuoteData(
                18,
                "Energy and persistence conquer all things.",
                authorList[0]
            )
        ) // Nelson Mandela
        perseveranceQuotes.add(
            QuoteData(
                19,
                "It's not that I'm so smart; it's just that I stay with problems longer.",
                authorList[17]
            )
        ) // Albert Einstein
        perseveranceQuotes.add(
            QuoteData(
                20,
                "Our greatest weakness lies in giving up. The most certain way to succeed is always to try just one more time.",
                authorList[8]
            )
        ) // Winston Churchill
        perseveranceQuotes.add(
            QuoteData(
                21,
                "In the confrontation between the stream and the rock, the stream always wins—not through strength but by perseverance.",
                authorList[16]
            )
        ) // Michael Jordan
        perseveranceQuotes.add(
            QuoteData(
                22,
                "To keep trying after failure is the mark of a true champion.",
                authorList[5]
            )
        ) // Mark Twain
        perseveranceQuotes.add(
            QuoteData(
                23,
                "Fall down seven times, stand up eight.",
                authorList[17]
            )
        ) // Albert Einstein
        perseveranceQuotes.add(
            QuoteData(
                24,
                "To persevere in one's duty and be silent is the best answer to calumny.",
                authorList[4]
            )
        ) // Theodore Roosevelt
        perseveranceQuotes.add(
            QuoteData(
                25,
                "Success is a journey, not a destination. The doing is often more important than the outcome.",
                authorList[9]
            )
        ) // Mahatma Gandhi
    }

}