package com.example.dogu.myquizapplication.DbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dogu.myquizapplication.Model.QuestionEczacilik;
import com.example.dogu.myquizapplication.Model.QuestionHukuk;
import com.example.dogu.myquizapplication.Model.QuestionIktisat;
import com.example.dogu.myquizapplication.Model.QuestionMuhendislik;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "Quizx.db";
        private static final String KEY_ID = "id";
        private static final String KEY_QUES = "question";
        private static final String KEY_ANSWER = "answer"; //correct option
        private static final String KEY_OPTA= "opta"; //option a
        private static final String KEY_OPTB= "optb"; //option b
        private static final String KEY_OPTC= "optc"; //option c
        private static final String KEY_OPTD= "optd"; //option d
        private static final String KEY_CAT="category"; //category

        private static final String TABLE_QUEST1 = "questHukuk";
        private static final String TABLE_QUEST2 = "questKisat";
        private static final String TABLE_QUEST3 = "questMuhendislik";
        private static final String TABLE_QUEST = "questEczacilik";

        public static final String TABLE_SCORE="score";
        public static final String SCORE_KEY_ID="id";
        public static final String SCORE_KEY_SECTION="section";
        public static final String SCORE_KEY_CAT="category";
        public static final String SCORE_KEY_SCORE="score";
        public static final String SCORE_UserID = "userID";
        public static final String SCORE_COUNT ="count";


private SQLiteDatabase dbase;

public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        }

public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, version);
        }

@Override
public void onCreate(SQLiteDatabase db) {
        dbase=db;

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
        + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
        + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
        +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
        db.execSQL(sql);
        addQuestionsEczacilik();

        String sql1 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST1 + " ( "
        + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
        + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
        +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
        db.execSQL(sql1);
        addQuestionsHukuk();


        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST2 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
        db.execSQL(sql2);
        addQuestionsIktisat();

        String sql3 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST3 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
        db.execSQL(sql3);
        addQuestionsMuhendislik();


        String sql4 = "CREATE TABLE IF NOT EXISTS "+ TABLE_SCORE+" ( "
        + SCORE_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SCORE_KEY_SECTION
        + " TEXT, " + SCORE_KEY_CAT+ " TEXT, "+ SCORE_KEY_SCORE+" INTEGER ,"+ SCORE_UserID+" TEXT,"+ SCORE_COUNT+ " INTEGER DEFAULT 0)";
        db.execSQL(sql4);
        }

private void addQuestionsHukuk() {
        QuestionHukuk q101 = new QuestionHukuk("Aşağıdakilerden hangisi Medeni Hukuk Kurallarından biri değildir?","Evlenme","Hırsızlık suçu","Hak ve Fiil Ehliyeti","İkâmetgah","Hırsızlık suçu","B");
        this.addQuestionHukuk(q101);
        QuestionHukuk q102 = new QuestionHukuk("In order to write on a floppy disk with your IBM PC, you must first","digitize it","format it","compile it","hardware it","format it","B");
        this.addQuestionHukuk(q102);
        QuestionHukuk q103 = new QuestionHukuk("What is the term for a temporary storage area tha componsates for differences in data rate and data flow between devices ?","Buffer","Bus","Channel","Modem","Buffer","B");
        this.addQuestionHukuk(q103);
        QuestionHukuk q104 = new QuestionHukuk("How many colour dots make up one colour pixel on a screen ?","256","16","3","1","3","B");
        this.addQuestionHukuk(q104);
        QuestionHukuk q105 = new QuestionHukuk("One of the things that separates a TERMINAL from a PC is that the terminal does not have a what ?","Keyboard","Monitor","Power Cord","CPU","CPU","B");
        this.addQuestionHukuk(q105);
        QuestionHukuk q106 = new QuestionHukuk("Data is stored on diskette in what form ?","Ink","Laser Bubble","Magnetism","Circuits","Magnetism","B");
        this.addQuestionHukuk(q106);
        QuestionHukuk q107 = new QuestionHukuk("The smallest visual element on a video monitor is called what ?","Character","Pixel","Byte","Kwerk","Pixel","B");
        this.addQuestionHukuk(q107);
        QuestionHukuk q108 = new QuestionHukuk("The type of data storage that is considered to be volatile is ?","R-O-M","R-A-M","TAPE","DISK","R-A-M","B");
        this.addQuestionHukuk(q108);
        QuestionHukuk q109 = new QuestionHukuk("What natural element is the primary ingredient in computer chips ?","Silicon","Carbon","Iron","Uranium","Silicon","B");
        this.addQuestionHukuk(q109);
        QuestionHukuk q110 = new QuestionHukuk("Where do you find a write protect notch ?","On a computer chip","On a punched card","In a read only memory","On a floppy disk","On a floppy disk","B");
        this.addQuestionHukuk(q110);
        QuestionHukuk q111 = new QuestionHukuk("Which of the following languages is more suited to a structured program?","PL/1","FORTRAN","BASIC","PASCAL","PASCAL","B");
        this.addQuestionHukuk(q111);
        QuestionHukuk q112 = new QuestionHukuk("A computer assisted method for the recording and analyzing of existing or hypothetical systems is","Data transmission","Data flow","Data capture","Data processing","Data flow","B");
        this.addQuestionHukuk(q112);
        QuestionHukuk q113 = new QuestionHukuk("The brain of any computer system is","ALU","CPU","Memory","Control unit","CPU","B");
        this.addQuestionHukuk(q113);
        QuestionHukuk q114 = new QuestionHukuk("What difference does the 5th generation computer have from other generation computers?","Technological advancement","Scientific code","Object Oriented Programming","All of the above","Technological advancement","B");
        this.addQuestionHukuk(q114);
        QuestionHukuk q115 = new QuestionHukuk("Which of the following computer language is used for artificial intelligence?","FORTRAN","PROLOG","C","COBOL","PROLOG","B");
        this.addQuestionHukuk(q115);
        QuestionHukuk q116 = new QuestionHukuk("The tracks on a disk which can be accessed without repositioning the R/W heads is","Surface","Cylinder","Cluster","All of the above","Cylinder","B");
        this.addQuestionHukuk(q116);
        QuestionHukuk q117 = new QuestionHukuk("Which of the following is the 1's complement of 10?","01","110","11","10","01","B");
        this.addQuestionHukuk(q117);
        QuestionHukuk q118 = new QuestionHukuk("A section of code to which control is transferred when a processor is interrupted is known as","M","SVC","IP","MDR","M","B");
        this.addQuestionHukuk(q118);
        QuestionHukuk q119 = new QuestionHukuk("Which part interprets program instructions and initiate control operations.","Input","Storage unit","Logic unit","Control unit","Control unit","B");
        this.addQuestionHukuk(q119);
        QuestionHukuk q120 = new QuestionHukuk("The binary system uses powers of","2","10","8","16","2","B");
        this.addQuestionHukuk(q120);
        QuestionHukuk q121 = new QuestionHukuk("A computer program that converts assembly language to machine language is","Compiler","Interpreter","Assembler","Comparator","Assembler","B");
        this.addQuestionHukuk(q121);
        QuestionHukuk q122 = new QuestionHukuk("The time required for the fetching and execution of one simple machine instruction is","Delay time","CPU cycle","Real time","Seek time","CPU cycle","B");
        this.addQuestionHukuk(q122);
        QuestionHukuk q123 = new QuestionHukuk("The time for which a piece of equipment operates is called","Seek time","Effective time","Access time","Real time","Effective time","B");
        this.addQuestionHukuk(q123);
        QuestionHukuk q124 = new QuestionHukuk("Binary numbers need more places for counting because","They are always big numbers","Any no. of 0's can be added in front of them","Binary base is small","0's and l's have to be properly spaced apart","Binary base is small","B");
        this.addQuestionHukuk(q124);
        QuestionHukuk q125 = new QuestionHukuk("Which access method is used for obtaining a record from a cassette tape?","Direct","Sequential","Random","All of the above","Sequential","B");
        this.addQuestionHukuk(q125);
        QuestionHukuk q126 = new QuestionHukuk("Any type of storage that is used for holding information between steps in its processing is","CPU","Primary storage","Intermediate storage","Internal storage","Intermediate storage","B");
        this.addQuestionHukuk(q126);
        QuestionHukuk q127 = new QuestionHukuk("A name applied by Intel corp. to high speed MOS technology is called","HDLC","LAP","HMOS","SDLC","HMOS","B");
        this.addQuestionHukuk(q127);
        QuestionHukuk q128 = new QuestionHukuk("A program component that allows structuring of a program in an unusual way is known as","Correlation","Coroutine","Diagonalization","Quene","Coroutine","B");
        this.addQuestionHukuk(q128);
        QuestionHukuk q129 = new QuestionHukuk("The radian of a number system","Is variable","Has nothing to do with digit position value","Equals the number of its distinct counting digits","Is always an even number","Equals the number of its distinct counting digits","B");
        this.addQuestionHukuk(q129);
        QuestionHukuk q130 = new QuestionHukuk("The section of the CPU that selects, interprets and sees to the execution of program instructions","Memory","Register unit","Control unit","ALU","Control unit","B");
        this.addQuestionHukuk(q130);
        QuestionHukuk q131 = new QuestionHukuk("Which type of system puts the user into direct conversation with the computer through a keyboard?","Real time processing","Interactive computer","Batch processing","Time sharing","Interactive computer","B");
        this.addQuestionHukuk(q131);
        QuestionHukuk q132 = new QuestionHukuk("The term referring to evacuating the content of some part of the machine is known as","Dump","Enhancement","Down","Compiler","Dump","B");
        this.addQuestionHukuk(q132);
        QuestionHukuk q133 = new QuestionHukuk("A single packet on a data link is known as","Path","Frame","Block","Group","Frame","B");
        this.addQuestionHukuk(q133);
        QuestionHukuk q134 = new QuestionHukuk("The process of communicating with a file from a terminal is","Interactive","Interrogation","Heuristic","All of the above","Interrogation","B");
        this.addQuestionHukuk(q134);
        QuestionHukuk q135 = new QuestionHukuk("A common boundary between two systems is called","Interdiction","Interface","Surface","None of the above","Interface","B");
        this.addQuestionHukuk(q135);
        QuestionHukuk q136 = new QuestionHukuk("The examination and changing of single bits or small groups of his within a word is called","Bit","Byte","Bit manipulation","Bit slice","Bit manipulation","B");
        this.addQuestionHukuk(q136);
        QuestionHukuk q137 = new QuestionHukuk("Which computer has been designed to be as compact as possible?","Mini","Super computer","Micro computer","Mainframe","Micro computer","B");
        this.addQuestionHukuk(q137);
        QuestionHukuk q138 = new QuestionHukuk("Which method is used to connect a remote computer?","Device","Dialup","Diagnostic","Logic circuit","Dialup","B");
        this.addQuestionHukuk(q138);
        QuestionHukuk q139 = new QuestionHukuk("How many bit code is used by Murray code for TELEPRINTER machines.","4","5","9","25","5","B");
        this.addQuestionHukuk(q139);
        QuestionHukuk q140 = new QuestionHukuk("The symbols used in an assembly language are","Codes","Mnemonics","Assembler","All of the above","Mnemonics","B");
        this.addQuestionHukuk(q140);
        QuestionHukuk q141 = new QuestionHukuk("The 2's complement of a binary no. is obtained by adding.....to its 1's complement.","0","1","10","12","1","B");
        this.addQuestionHukuk(q141);
        QuestionHukuk q142 = new QuestionHukuk("A systems programming language for microcomputers in the Intel family is","PL/C","PL/CT","PL/M","PLA","PL/M","B");
        this.addQuestionHukuk(q142);
        QuestionHukuk q143 = new QuestionHukuk("A datum that indicates some important state in the content of input or output is","Sequence","Sentinel","SIO","Sibling","Sentinel","B");
        this.addQuestionHukuk(q143);
        QuestionHukuk q144 = new QuestionHukuk("Which is a non-standard version of a computing language?","PROLOG","APL","Army","PL/1","Army","B");
        this.addQuestionHukuk(q144);
        QuestionHukuk q145 = new QuestionHukuk("Which of the following is still useful for adding numbers?","EDSAC","ENIAC","Abacus","UNIVAC","Abacus","B");
        this.addQuestionHukuk(q145);
        QuestionHukuk q146 = new QuestionHukuk("The average time necessary for the correct sector of a disk to arrive at the read write head is _____","Down time","Seek time","Rotational delay","Access time","Rotational delay","B");
        this.addQuestionHukuk(q146);
        QuestionHukuk q147 = new QuestionHukuk("A number that is used to control the form of another number is known as","Map","Mask","Mamtossa","Marker","Mask","B");
        this.addQuestionHukuk(q147);
        QuestionHukuk q148 = new QuestionHukuk("A general purpose single-user microcomputer designed to be operated by one person at a time is","Special-purpose computer","KIPS","M","PC","PC","B");
        this.addQuestionHukuk(q148);
        QuestionHukuk q149 = new QuestionHukuk("ASCII stands for","American standard code for information interchange","All purpose scientific code for information interchange","American security code for information interchange","American Scientific code for information interchange","American standard code for information interchange","B");
        this.addQuestionHukuk(q149);
        QuestionHukuk q150 = new QuestionHukuk("Which device of computer operation dispenses with the use of the keyboard?","Joystick","Light pen","Mouse","Touch","Mouse","B");
        this.addQuestionHukuk(q150);
                QuestionHukuk q151 = new QuestionHukuk("The microcomputer, Intel MCS-80 is based on the widely used Intel","8080 microprocessor","8085 microprocessor","8086 microprocessor","8082 microprocessor","8080 microprocessor","B");
        this.addQuestionHukuk(q151);
        QuestionHukuk q152 = new QuestionHukuk("Which is a machine-oriented high-level language for the GEC 4080 series machines.","LOGO","SNOBOL","Babbage","ALGOL","Babbage","B");
        this.addQuestionHukuk(q152);
        QuestionHukuk q153 = new QuestionHukuk("A program that is employed in the development, repair or enhancement of other programs is known as","System software","Software tool","Applications program","Utility program","Software tool","B");
        this.addQuestionHukuk(q153);
        QuestionHukuk q154 = new QuestionHukuk("Any storage device added to a computer beyond the immediately usable main storage is known as","Floppy disk","Hard disk","Backing store","Punched card","Backing store","B");
        this.addQuestionHukuk(q154);
        QuestionHukuk q155 = new QuestionHukuk("Which output device is used for translating information from a computer into pictorial form on paper.","Mouse","Plotter","Touch panel","Card punch","Plotter","B");
        this.addQuestionHukuk(q155);
        QuestionHukuk q156 = new QuestionHukuk("The list of coded instructions is called","Computer program","Algorithm","Flowchart","Utility programs","Computer program","B");
        this.addQuestionHukuk(q156);
        QuestionHukuk q157 = new QuestionHukuk("A technique used by codes to convert an analog signal into a digital bit stream is known as","Pulse code modulation","Pulse stretcher","Query processing","Queue management","Pulse code modulation","B");
        this.addQuestionHukuk(q157);
        QuestionHukuk q158 = new QuestionHukuk("An optical input device that interprets pencil marks on paper media is","O.M.R","Punch card reader","Optical scanners","Magnetic tape","O.M.R","B");
        this.addQuestionHukuk(q158);
        QuestionHukuk q159 = new QuestionHukuk("Most important advantage of an IC is its","Easy replacement in case of circuit failure","Extremely high reliability","Reduced cost","Low power consumption","Extremely high reliability","B");
        this.addQuestionHukuk(q159);
        QuestionHukuk q160 = new QuestionHukuk("Data division is the third division of a _____ program.","COBOL","BASIC","PASCAL","FORTH","COBOL","B");
        this.addQuestionHukuk(q160);
        QuestionHukuk q161 = new QuestionHukuk("Which language was devised by Dr. Seymour Aubrey Papert?","APL","COBOL","LOGO","FORTRAN","LOGO","B");
        this.addQuestionHukuk(q161);
        QuestionHukuk q162 = new QuestionHukuk("A program that converts computer data into some code system other than the normal one is known as","Encoder","Simulation","Emulator","Coding","Encoder","B");
        this.addQuestionHukuk(q162);
        QuestionHukuk q163 = new QuestionHukuk("A device designed to read information encoded into a small plastic card is","Magnetic tape","Badge reader","Tape puncher","Card puncher","Badge reader","B");
        this.addQuestionHukuk(q163);
        QuestionHukuk q164 = new QuestionHukuk("A hybrid computer uses a _____ to convert digital signals from a computer into analog signals.","Modulator","Demodulator","Modem","Decoder","Modem","B");
        this.addQuestionHukuk(q164);
        QuestionHukuk q165 = new QuestionHukuk("A group of magnetic tapes, videos or terminals usually under the control of one master is","Cylinder","Cluster","Surface","Track","Cluster","B");
        this.addQuestionHukuk(q165);
        QuestionHukuk q166 = new QuestionHukuk("Any device that performs signal conversion is","Modulator","Modem","Keyboard","Plotter","Modulator","B");
        this.addQuestionHukuk(q166);
        QuestionHukuk q167 = new QuestionHukuk("Codes consisting of light and dark marks which may be optically read is known as","Mnemonics","Bar code","Decoder","All of the above","Bar code","B");
        this.addQuestionHukuk(q167);
        QuestionHukuk q168 = new QuestionHukuk("A type of channel used to connect a central processor and peripherals which uses multipling is known as","Modem","Network","Multiplexer","All of the above","Multiplexer","B");
        this.addQuestionHukuk(q168);
        QuestionHukuk q169 = new QuestionHukuk("The first generation of computers available was based on the bit micro processors.","4","8","16","64","8","B");
        this.addQuestionHukuk(q169);
        QuestionHukuk q170 = new QuestionHukuk("The complete picture of data stored in database is known as","Record","Schema","System flowchart","DBMS","Schema","B");
        this.addQuestionHukuk(q170);
        QuestionHukuk q171 = new QuestionHukuk("Which of the following is intended to be used in all applications runs on mainframe computers.","LOGO","APL","PL/1","OCCAM","PL/1","B");
        this.addQuestionHukuk(q171);
        QuestionHukuk q172 = new QuestionHukuk("A language which is close to that used within the computer is","High-level language","Assembly language","Low-level language","All of the above","Low-level language","B");
        this.addQuestionHukuk(q172);
        QuestionHukuk q173 = new QuestionHukuk("Which is a unit representing the no bits of discrete.","Baud","Byte","Bit","All of the above","Baud","B");
        this.addQuestionHukuk(q173);
        QuestionHukuk q174 = new QuestionHukuk("The device that can both feed data into and accept data from a computer is","ALU","CPU","Input-Output device","All of the above","Input-Output device","B");
        this.addQuestionHukuk(q174);
        QuestionHukuk q175 = new QuestionHukuk("The personnel who deals with the computer & its management put together are called","Software","Humanware","Firmware","Hardware","Humanware","B");
        this.addQuestionHukuk(q175);
        QuestionHukuk q176 = new QuestionHukuk("A modern digital computer has","Extremely high speed","Large memory","Almost unlimited array","All of the above","All of the above","B");
        this.addQuestionHukuk(q176);
        QuestionHukuk q177 = new QuestionHukuk("Which of the following can store information in the form of microscopic pits on metal disks.","Laser disks","Tape cassettes","RAM cartridge","Punched cards","Laser disks","B");
        this.addQuestionHukuk(q177);
        QuestionHukuk q178 = new QuestionHukuk("A device for converting handwritten impressions into coded characters & positional coordinates for input to a computer is","Touch panel","Mouse","Wand","Writing tablet","Writing tablet","B");
        this.addQuestionHukuk(q178);
        QuestionHukuk q179 = new QuestionHukuk("A storage system for small amounts of data is","Magnetic card","Magnetic tape","Punched card","Optical mark reader","Magnetic card","B");
        this.addQuestionHukuk(q179);
        QuestionHukuk q180 = new QuestionHukuk("Which is another name for functional language?","Machine","Application language","Low-level language","High-level language","Application language","B");
        this.addQuestionHukuk(q180);
        QuestionHukuk q181 = new QuestionHukuk("Compilers and interpreters are themselves","High-level language","Codes","Programs","Mnemonics","Programs","B");
        this.addQuestionHukuk(q181);
        QuestionHukuk q182 = new QuestionHukuk("A compiler means","A person who compiles source programs","The same thing as a programmer","Keypunch operator","A program which translates source program into object program","A program which translates source program into object program","B");
        this.addQuestionHukuk(q182);
        QuestionHukuk q183 = new QuestionHukuk("A pen shaped device which can sense light, and is used to point at spots on a video screen.","Mouse","Light pen","Joystick","Plotter","Light pen","B");
        this.addQuestionHukuk(q183);
        QuestionHukuk q184 = new QuestionHukuk("A notation used to express clearly on algorithm is known as","Algorithmic language","Assembly language","Machine language","High level language","Algorithmic language","B");
        this.addQuestionHukuk(q184);
        QuestionHukuk q185 = new QuestionHukuk("Compression of digital data for efficient storage is","Buffer","CPU","Packing","Field","Packing","B");
        this.addQuestionHukuk(q185);
        QuestionHukuk q186 = new QuestionHukuk("An operating system intended for use on microprocessor based systems that support a single user is","PC-DOS","MS-DOS","UNIX","CP/M","CP/M","B");
        this.addQuestionHukuk(q186);
        QuestionHukuk q187 = new QuestionHukuk("Which programming language is based on Algol 60.","PILOT","SNOBOL","ADA","SIMULA","SIMULA","B");
        this.addQuestionHukuk(q187);
        QuestionHukuk q188 = new QuestionHukuk("Computer memory consists of","RAM","ROM","PROM","All of the above","All of the above","B");
        this.addQuestionHukuk(q188);
        QuestionHukuk q189 = new QuestionHukuk("A path by which communication is achieved between a central processor and other devices is called","Audit trail","Network","Bus","Channel","Bus","B");
        this.addQuestionHukuk(q189);
        QuestionHukuk q190 = new QuestionHukuk("A stand-alone system which produces one page of printed output at a time is","Page printer","Line printer","Laser printer","Dot matrix printer","Page printer","B");
        this.addQuestionHukuk(q190);
        QuestionHukuk q191 = new QuestionHukuk("A memory that does not change its contents without external causes is known as","Dynamic memory","Static memory","RAM","EEPROM","Static memory","B");
        this.addQuestionHukuk(q191);
        QuestionHukuk q192 = new QuestionHukuk("The report card and merit list forms the","Output data","Data processing","Central Processing","Input data","Output data","B");
        this.addQuestionHukuk(q192);
        QuestionHukuk q193 = new QuestionHukuk("A number which is stored and processed but not in the standard exponential form is called","Floating point number","Fixed point number","Octal number","Decimal number","Fixed point number","B");
        this.addQuestionHukuk(q193);
        QuestionHukuk q194 = new QuestionHukuk("A memory that holds micro programs is","Core memory","ROM","RAM","Control memory","ROM","B");
        this.addQuestionHukuk(q194);
        QuestionHukuk q195 = new QuestionHukuk("A device invented by Dr. Bobeck in 1966, for mass storage of data is","Punched paper tape","Magnetic bubble storage","Magnetic tape","Magnetic disk","Magnetic bubble storage","B");
        this.addQuestionHukuk(q195);
        QuestionHukuk q196 = new QuestionHukuk("The organization and interconnection of the various components of a computer system is","Architecture","Networks","Graphics","Designing","Architecture","B");
        this.addQuestionHukuk(q196);
        QuestionHukuk q197 = new QuestionHukuk("Which of the following is the coding of data so that is can't be easily understood if intercepted.","Barcode","Decoder","Encryption","Mnemonics","Encryption","B");
        this.addQuestionHukuk(q197);
        QuestionHukuk q198 = new QuestionHukuk("RAM is used as a short memory because it is","Volatile","Has small capacity","Is very expensive","Is programmable","Volatile","B");
        this.addQuestionHukuk(q198);
        QuestionHukuk q199 = new QuestionHukuk("A modern electronic computer is a machine that is meant for","Doing quick mathematical calculations","Input storage, manipulation of outputting of data","Electronic data processing","Performing repetitive tasks accurately","Input storage, manipulation of outputting of data","B");
        this.addQuestionHukuk(q199);
        QuestionHukuk q200 = new QuestionHukuk("Which is a device that changes information into digital form?","Modem","Digitizer","Mouse","Light pen","Digitizer","B");
        this.addQuestionHukuk(q200);
        QuestionHukuk q201 = new QuestionHukuk("Which one of the following four words is odd?","Application","Peripheral","Program","Software","Peripheral","B");
        this.addQuestionHukuk(q201);
        QuestionHukuk q202 = new QuestionHukuk("A CPU contains","a card reader","an analytical engine","control unit and ALU","only ALU","control unit and ALU","B");
        this.addQuestionHukuk(q202);
        QuestionHukuk q203 = new QuestionHukuk("Which of the following controls the process of interaction between the user and the operating system?","user interface","language translator","platform","screen saver","user interface","B");
        this.addQuestionHukuk(q203);
        QuestionHukuk q204= new QuestionHukuk("The first computers were programmed using","assembly language","machine language","source code","object code","machine language","B");
        this.addQuestionHukuk(q204);
        QuestionHukuk q205= new QuestionHukuk("Is a combination of hardware and software that facilitates the sharing of information between computing devices","network","peripheral","expansion board","digital device","network","B");
        this.addQuestionHukuk(q205);
        QuestionHukuk q206= new QuestionHukuk("The settings automatic and standard are called as","default","icon","CPU","custom","default","B");
        this.addQuestionHukuk(q206);
        QuestionHukuk q207= new QuestionHukuk("Coded entries which are used to gain access to a computer system are called","entry codes","passwords","security commands","code words","passwords","B");
        this.addQuestionHukuk(q207);
        QuestionHukuk q208= new QuestionHukuk("You can organize files by storing them in","archives","folders","indexes","lists","folders","B");
        this.addQuestionHukuk(q208);
        QuestionHukuk q209= new QuestionHukuk("How many different documents can you have open at any one time ?","not more than 3","only one","as many as your computer memory will hold","maximum five","as many as your computer memory will hold","B");
        this.addQuestionHukuk(q209);
        QuestionHukuk q210= new QuestionHukuk("Directory in directory is called","mini directory","junior directory","part directory","sub directory","sub directory","B");
        this.addQuestionHukuk(q210);
        QuestionHukuk q211= new QuestionHukuk("Saving is a process","To copy the document from memory to storage medium","To bring change in present status of the document","To change the face or entire form","To develop the document by recording the text with the use of keyboard","To copy the document from memory to storage medium","B");
        this.addQuestionHukuk(q211);
        QuestionHukuk q212= new QuestionHukuk("Junk email is also called-","spam","spoof","sniffer script","spool","spam","B");
        this.addQuestionHukuk(q212);
        QuestionHukuk q213= new QuestionHukuk("What type of computers are client computers?","Mainframe","Mini-computer","Micro-computer","PDA","Micro-computer","B");
        this.addQuestionHukuk(q213);
        QuestionHukuk q214= new QuestionHukuk("Hackers-","all have same motive","break into other people computers","computer scientist","are good people","break into other people computers","B");
        this.addQuestionHukuk(q214);
        QuestionHukuk q215= new QuestionHukuk("A computer cannot boot if it does not have","compiler","loader","operating system","assembler","operating system","B");
        this.addQuestionHukuk(q215);
        QuestionHukuk q216= new QuestionHukuk("Example of non numeric data","address","exam score","bank balance","all of these","address","B");
        this.addQuestionHukuk(q216);
        QuestionHukuk q217= new QuestionHukuk("First page of website-","home page","index","javascript","bookmark","home page","B");
        this.addQuestionHukuk(q217);
        QuestionHukuk q218= new QuestionHukuk("The appearance of typed characters is-","size","format","point","color","format","B");
        this.addQuestionHukuk(q218);
        QuestionHukuk q219= new QuestionHukuk("Office LANS, which are scattered geographically on large scale, can be connected by the use of corporate-","CAN","MAN","LAN","WAN","WAN","B");
        this.addQuestionHukuk(q219);
        QuestionHukuk q220= new QuestionHukuk("Where are data and program stored when the processor uses them?","main memory","secondary memory","disk","program memory","main memory","B");
        this.addQuestionHukuk(q220);
        QuestionHukuk q221= new QuestionHukuk("If the file saved earlier is edited, then-","It is essential to save the file again to store the change","The change will automatically be saved in the file","If the length is more than a page, the file will be needed to be saved","The name will be needed to be changed","It is essential to save the file again to store the change","B");
        this.addQuestionHukuk(q221);
        QuestionHukuk q222= new QuestionHukuk("CAD stands for","Computer aided design","Computer algorithm for design","Computer application in design","All of the above","Computer aided design","B");
        this.addQuestionHukuk(q222);
        QuestionHukuk q223= new QuestionHukuk("The word FTP stands for","File Transit Protocol","File Translate Protocol","File Transfer Protocol","File Typing Protocol","File Transfer Protocol","B");
        this.addQuestionHukuk(q223);
        QuestionHukuk q224= new QuestionHukuk("Memory which forgets everything when you switch off the power is known as","Corrupted","Volatile","Non Volatile","Non Corrupted","Volatile","B");
        this.addQuestionHukuk(q224);
        QuestionHukuk q225= new QuestionHukuk("The linking of computers with a communication system is called","networking","pairing","locking","assembling","networking","B");
        this.addQuestionHukuk(q225);
        QuestionHukuk q226= new QuestionHukuk("The 16 bit Microprocessor means that it has","16 address lines","16 bus","16 data lines","16 routes","16 data lines","B");
        this.addQuestionHukuk(q226);
        QuestionHukuk q227= new QuestionHukuk("Data going into the computers is called","output","algorithm","input","flowchart","input","B");
        this.addQuestionHukuk(q227);
        QuestionHukuk q228= new QuestionHukuk("Data coming from the computers is called","output","algorithm","input","flowchart","output","B");
        this.addQuestionHukuk(q228);
        QuestionHukuk q229= new QuestionHukuk("Which of the following refers to a small, single-site network?","LAN","DSL","RAM","USB","LAN","B");
        this.addQuestionHukuk(q229);
        QuestionHukuk q230= new QuestionHukuk("How many options does a binary choice offer?","Zero","One","Two","Three","Two","B");
        this.addQuestionHukuk(q230);
        QuestionHukuk q231= new QuestionHukuk("A collection of program that controls how your computer system runs and processes information is called","operating system","computer","office","compiler","operating system","B");
        this.addQuestionHukuk(q231);
        QuestionHukuk q232= new QuestionHukuk("Computer connected to a LAN (Local Area Network) can","run fast","be online","share peripherals","email","share peripheral","B");
        this.addQuestionHukuk(q232);
        QuestionHukuk q233= new QuestionHukuk("Information travels between components on the mother board through","Flash memory","CMOS","Buses","Peripherals","Buses","B");
        this.addQuestionHukuk(q233);
        QuestionHukuk q234= new QuestionHukuk("How are data organized in a spreadsheet?","Lines and spaces","Layers","Height and Width","Rows and Columns","Rows and Columns","B");
        this.addQuestionHukuk(q234);
        QuestionHukuk q235= new QuestionHukuk("The blinking symbol on the computer screen is called the","mouse","hand","cursor","palm","cursor","B");
        this.addQuestionHukuk(q235);
        QuestionHukuk q236= new QuestionHukuk("A fault in a computer program which prevents it from working correctly is known as","Boot","Bug","Bit","Binary","Bug","B");
        this.addQuestionHukuk(q236);
        QuestionHukuk q237= new QuestionHukuk("How many options does a octal system offer?","Eight","Four","Two","Three","Eight","B");
        this.addQuestionHukuk(q237);
        QuestionHukuk q238= new QuestionHukuk("How many options does a hexadecimal system offer?","Eight","Six","Sixteen","Three","Sixteen","B");
        this.addQuestionHukuk(q238);
        QuestionHukuk q239=new QuestionHukuk("Father of C programming language","Dennis Ritchie","John Kennedy","Bill Gates","James Gosling","Dennis Ritchie","B");
        this.addQuestionHukuk(q239);
        QuestionHukuk q240=new QuestionHukuk("Father of Java programming language","Dennis Ritchie","John Kennedy","Bill Gates","James Gosling","James Gosling","B");
        this.addQuestionHukuk(q240);
        QuestionHukuk q241= new QuestionHukuk("BIOS stands for","Basic Input Output system","Binary Input output system","Basic Input Off system","All of the above","Basic Input Output system","B");
        this.addQuestionHukuk(q241);
        QuestionHukuk q242= new QuestionHukuk("VDU is also called","Screen","Monitor","Both 1 & 2","Printer","Both 1 & 2","B");
        this.addQuestionHukuk(q242);
        QuestionHukuk q243= new QuestionHukuk("The device used to carry digital data on analog lines is called as","Modem","Multiplexer","DeMultiplexer","Modulator","Modem","B");
        this.addQuestionHukuk(q243);
        QuestionHukuk q244= new QuestionHukuk("SMPS stands for","Switched mode Power Supply","Start mode power supply","Store mode power supply","Single mode power supply","Switched mode Power Supply","B");
        this.addQuestionHukuk(q244);
        QuestionHukuk q245= new QuestionHukuk("1 Byte = ?","8 bits","4 bits","2 bits","1 bit","8 bits","B");
        this.addQuestionHukuk(q245);
        QuestionHukuk q246= new QuestionHukuk("Which of the following is an OOP Principle","Structured Programming","Procedural Programming","Inheritance","Linking","Inheritance","B");
        this.addQuestionHukuk(q246);
        QuestionHukuk q247= new QuestionHukuk("Which command divides the surface of the blank disk into sectors and assign a unique address to each one","Ver","Format","Fat","Check Disk","Format","B");
        this.addQuestionHukuk(q247);
        QuestionHukuk q248= new QuestionHukuk("Every computer connected to an intranet or extranet must have a distinct","firewall","Proxy Server","Domain Name","IP address","IP address","B");
        this.addQuestionHukuk(q248);
        QuestionHukuk q249= new QuestionHukuk("Firewalls are used to protect against","Unauthorized Attacks","Viruses","Fire Attacks","Data Driven Attacks","Unauthorized Attacks","B");
        this.addQuestionHukuk(q249);
        QuestionHukuk q250= new QuestionHukuk("The first Digital Computer introduced, was named as ","UNIVAC","EDSAC","ENIAC","MARK-1","MARK-1","B");
        this.addQuestionHukuk(q250);

        }

public void addQuestionHukuk(QuestionHukuk quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION1());
        values.put(KEY_ANSWER, quest.getANSWER1());
        values.put(KEY_OPTA, quest.getOPTA1());
        values.put(KEY_OPTB, quest.getOPTB1());
        values.put(KEY_OPTC, quest.getOPTC1());
        values.put(KEY_OPTD, quest.getOPTD1());
        values.put(KEY_CAT,quest.getCATEGORY1());
        // Inserting Row
        dbase.insert(TABLE_QUEST1, null, values);
        }

private void addQuestionsEczacilik(){
        QuestionEczacilik q1 = new QuestionEczacilik("Which backup method is quickest and requires the least amount of backup storage space ?","Daily","Normal","Differential","Incremental","Incremental","B");
        this.addQuestionEczacilik(q1);
        QuestionEczacilik q2 = new QuestionEczacilik("Scan disk checks and fixes ____.","Tape drives","Hard drives","CD-ROM drives","DVD-ROM drives","Hard drives","B");
        this.addQuestionEczacilik(q2);
        QuestionEczacilik q3 = new QuestionEczacilik("Where is the DIR command located ?","C:|WINDOWS","COMMAND.COM","C:|WINDOWS|SYSTEM","C:|WINDOWS|COMMAND","COMMAND.COM","B");
        this.addQuestionEczacilik(q3);
        QuestionEczacilik q4 = new QuestionEczacilik("Which command allows you to view or edit configuration files ?","SYSEDIT","REGEDIT","CFGEDIT","AUTOEDIT","SYSEDIT","B");
        this.addQuestionEczacilik(q4);
        QuestionEczacilik q5 = new QuestionEczacilik("Which utility is the best for editing Windows 95 registry ?","Edit","Regedit","Reged32","Device Manager","Regedit","B");
        this.addQuestionEczacilik(q5);
        QuestionEczacilik q6 = new QuestionEczacilik("Which files determines the multiboot configuration of Windows 9x ?","IO.SYS","SYSTEM.INI","MSDOS.SYS","CONFIG.SYS","MSDOS.SYS","B");
        this.addQuestionEczacilik(q6);
        QuestionEczacilik q7 = new QuestionEczacilik("Which key strokes switch a user between simultaneously running applications in windows ?","FN+TAB","ALT+TAB","CTRL+TAB","SHIFT+TAB","ALT+TAB","B");
        this.addQuestionEczacilik(q7);
        QuestionEczacilik q8 = new QuestionEczacilik("WHat type of file is the Windows 9x registry ?","Flat text file","Relational database","Hierarchical databse","Spread sheet template","Hierarchical databse","B");
        this.addQuestionEczacilik(q8);
        QuestionEczacilik q9 = new QuestionEczacilik("Wich of these statements would be found in the autoexec.bat file ?","FILES=40","PATH=C:\\;","DOS=HIGH,UMB","DEVICE=HIMEM.SYS","PATH=C:\\;","B");
        this.addQuestionEczacilik(q9);
        QuestionEczacilik q10 = new QuestionEczacilik("What is the proper command to install the Windows 2000 Recovery Console as a start up option if the CD Rom is Drive E ?","E:|i386\\SETUP.EXE\\CONSOLE","E:|i386\\CONSOLE.EXE\\INSTALL","E:|i386\\WINNT32.EXE\\CMDCONS","E:|i386\\WIN2000.EXE\\RECOVERY","E:|i386\\WINNT32.EXE\\CMDCONS","B");
        this.addQuestionEczacilik(q10);
        QuestionEczacilik q11 = new QuestionEczacilik("The part of machine level instruction, which tells the central processor what has to be done, is","Operation code","Address","Locator","Flip-Flop","Operation code","B");
        this.addQuestionEczacilik(q11);
        QuestionEczacilik q12 = new QuestionEczacilik("Which of the following refers to the associative memory?","the address of the data is generated by the CPU","the address of the data is supplied by the users","there is no need for an address i.e. the data is used as an address","the data are accessed sequentially","there is no need for an address i.e. the data is used as an address","B");
        this.addQuestionEczacilik(q12);
        QuestionEczacilik q13 = new QuestionEczacilik("To avoid the race condition, the number of processes that may be simultaneously inside their critical section is","8","16","1","0","1","B");
        this.addQuestionEczacilik(q13);
        QuestionEczacilik q14 = new QuestionEczacilik("A system program that combines the separately compiled modules of a program into a form suitable for execution","assembler","assembler","cross compiler","load and go","linking loader","B");
        this.addQuestionEczacilik(q14);
        QuestionEczacilik q15 = new QuestionEczacilik("Process is","program in High level language kept on disk","contents of main memory","a program in execution","a job in secondary memory","a program in execution","B");
        this.addQuestionEczacilik(q15);
        QuestionEczacilik q16 = new QuestionEczacilik("Addressing structure","defines the fundamental method of determining effective operand addresses","are variations in the use of fundamental addressing structures, or some associated actions which are related to addressing","performs indicated operations on two fast registers of the machine and leave the result in one of the registers","all of the above","defines the fundamental method of determining effective operand addresses","B");
        this.addQuestionEczacilik(q16);
        QuestionEczacilik q17 = new QuestionEczacilik("all of the above","is a hardware memory device which denotes the location of the current instruction being executed","is a group of electrical circuits (hardware), that performs the intent of instructions fetched from memory","contains the address of the memory location that is to be read from or stored into","contains a copy of the designated memory location specified by the MAR after a \"read\" or the new contents of the memory prior to a \"write\"","contains a copy of the designated memory location specified by the MAR after a \"read\" or the new contents of the memory prior to a \"write\"","B");
        this.addQuestionEczacilik(q17);
        QuestionEczacilik q18 = new QuestionEczacilik("The strategy of allowing processes that are logically runnable to be temporarily suspended is called","preemptive scheduling","non preemptive scheduling","shortest job first","shortest job first","preemptive scheduling","B");
        this.addQuestionEczacilik(q18);
        QuestionEczacilik q19 = new QuestionEczacilik("The LRU algorithm","pages out pages that have been used recently","pages out pages that have not been used recently","pages out pages that have been least used recently","pages out the first page in a given area","pages out pages that have been least used recently","B");
        this.addQuestionEczacilik(q19);
        QuestionEczacilik q20 = new QuestionEczacilik("Which of the following systems software does the job of merging the records from two files into one?","Security software","Utility program","Networking software","Documentation system","Utility program","B");
        this.addQuestionEczacilik(q20);
        QuestionEczacilik q21 = new QuestionEczacilik("Fork is","the dispatching of a task","the creation of a new job","the creation of a new process","increasing the priority of a task","the creation of a new process","B");
        this.addQuestionEczacilik(q21);
        QuestionEczacilik q22 = new QuestionEczacilik("Thrashing","is a natural consequence of virtual memory systems","can always be avoided by swapping","always occurs on large computers","can be caused by poor paging algorithms","can be caused by poor paging algorithms","B");
        this.addQuestionEczacilik(q22);
        QuestionEczacilik q23 = new QuestionEczacilik("Supervisor state is","never used","entered by programs when they enter the processor","required to perform any I/O","only allowed to the operating system","only allowed to the operating system","B");
        this.addQuestionEczacilik(q23);
        QuestionEczacilik q24 = new QuestionEczacilik("Which of the following instruction steps, would be written within the diamond-shaped box, of a flowchart?","S = B - C","IS A<10","PRINT A","DATA X,4Z","IS A<10","B");
        this.addQuestionEczacilik(q24);
        QuestionEczacilik q25 = new QuestionEczacilik("Which of the following statements is false?","the technique of storage compaction involves moving all occupied areas of storage to one end or other of main storage","compaction does not involve relocation of programs","compaction is also know as garbage collection","the system must stop everything while it performs the compaction","compaction does not involve relocation of programs","B");
        this.addQuestionEczacilik(q25);
        QuestionEczacilik q26 = new QuestionEczacilik("Interprocess communication","is required for all processes","is usually done via disk drives","is never necessary","allows processes to synchronize activity","allows processes to synchronize activity","B");
        this.addQuestionEczacilik(q26);
        QuestionEczacilik q27 = new QuestionEczacilik("Which of the following functions is(are) performed by the loader","allocate space in memory for the programs and resolve symbolic references between object decks","adjust all address dependent locations, such as address constants, to correspond to the allocated space","physically place the machine instructions and data into memory","All of the above","All of the above","B");
        this.addQuestionEczacilik(q27);
        QuestionEczacilik q28 = new QuestionEczacilik("User-Friendly Systems are:","required for object-oriented programming","easy to develop","common among traditional mainframe operating systems","becoming more common","becoming more common","B");
        this.addQuestionEczacilik(q28);
        QuestionEczacilik q29 = new QuestionEczacilik("Which of the following addressing modes, facilitates access to an operand whose location is defined relative to the beginning of the data structure in which it appears?","ascending","sorting","index","indirect","index","B");
        this.addQuestionEczacilik(q29);
        QuestionEczacilik q30 = new QuestionEczacilik("While running DOS on a PC, which command would be used to duplicate the entire diskette?","COPY","DISKCOPY","CHKDSK","TYPE","DISKCOPY","B");
        this.addQuestionEczacilik(q30);
        QuestionEczacilik q31 = new QuestionEczacilik("Memory","is a device that performs a sequence of operations specified by instructions in memory.","is the device where information is stored","is a sequence of instructions","is typically characterized by interactive processing and time-slicing of the CPU's time to allow quick response to each user.","is the device where information is stored","B");
        this.addQuestionEczacilik(q31);
        QuestionEczacilik q32 = new QuestionEczacilik("Which of the following rules out the use of GO TO?","Flowchart","HIPO-DIAGRAMS","Nassi-Shneiderman diagram","All of the above","Nassi-Shneiderman diagram","B");
        this.addQuestionEczacilik(q32);
        QuestionEczacilik q33 = new QuestionEczacilik("A system program that sets up an executable program in main memory ready for execution is","assembler","linker","loader","compiler","loader","B");
        this.addQuestionEczacilik(q33);
        QuestionEczacilik q34 = new QuestionEczacilik("A system program that sets up an executable program in main memory ready for execution is","assembler","linker","loader","compiler","loader","B");
        this.addQuestionEczacilik(q34);
        QuestionEczacilik q35 = new QuestionEczacilik("Which of the following are loaded into main memory when the computer is booted?","internal command instructions","external command instructions","utility programs","word processing instructions","internal command instructions","B");
        this.addQuestionEczacilik(q35);
        QuestionEczacilik q36 = new QuestionEczacilik("The FIFO algorithm","executes first the job that last entered the queue","executes first the job that first entered the queue","execute first the job that has been in the queue the longest","executes first the job with the least processor needs","executes first the job that first entered the queue","B");
        this.addQuestionEczacilik(q36);
        QuestionEczacilik q37 = new QuestionEczacilik("What is the name given to the organized collection of software that controls the overall operation of a computer?","Working system","Peripheral system","Operating system","Controlling system","Operating system","B");
        this.addQuestionEczacilik(q37);
        QuestionEczacilik q38 = new QuestionEczacilik("The principle of locality of reference justifies the use of","reenterable","non reusable","virtual memory","cache memory","cache memory","B");
        this.addQuestionEczacilik(q38);
        QuestionEczacilik q39 = new QuestionEczacilik("The register or main memory location which contains the effective address of the operand is known as","pointer","indexed register","special location","scratch pad","pointer","B");
        this.addQuestionEczacilik(q39);
        QuestionEczacilik q40 = new QuestionEczacilik("Assembly code data base is associated with","assembly language version of the program which is created by the code generation phase and is input to the assembly phase.","a permanent table of decision rules in the form of patterns for matching with the uniform symbol table to discover syntactic structure.","consists of a full or partial list or the token's as they appear in the program. Created by Lexical analysis and used for syntax analysis and interpretation.","a permanent table which lists all key words and special symbols of the language in symbolic form.","assembly language version of the program which is created by the code generation phase and is input to the assembly phase.","B");
        this.addQuestionEczacilik(q40);
        QuestionEczacilik q41 = new QuestionEczacilik("Thrashing can be avoided if","the pages, belonging to the working set of the programs, are in main memory","the speed of CPU is increased","the speed of I/O processor is increased","all of the above","the pages, belonging to the working set of the programs, are in main memory","B");
        this.addQuestionEczacilik(q41);
        QuestionEczacilik q42 = new QuestionEczacilik("In analyzing the compilation of PL/I program, the term \"Lexical analysis\" is associated with","recognition of basic syntactic constructs through reductions.","recognition of basic elements and creation of uniform symbols","creation of more optional matrix.","use of macro processor to produce more optimal assembly code","recognition of basic elements and creation of uniform symbols","B");
        this.addQuestionEczacilik(q42);
        QuestionEczacilik q43 = new QuestionEczacilik("Resolution of externally defined symbols is performed by","Linker","Loader","Compiler","Assembler","Linker","B");
        this.addQuestionEczacilik(q43);
        QuestionEczacilik q44 = new QuestionEczacilik("System generation:","is always quite simple","is always very difficult","varies in difficulty between systems","requires extensive tools to be understandable","varies in difficulty between systems","B");
        this.addQuestionEczacilik(q44);
        QuestionEczacilik q45 = new QuestionEczacilik("The Memory Address Register","is a hardware memory device which denotes the location of the current instruction being executed.","is a group of electrical circuits (hardware), that performs the intent of instructions fetched from memory.","contains the address of the memory location that is to be read from or stored into.","contains a copy of the designated memory location specified by the MAR after a \"read\" or the new contents of the memory prior to a \"write\".","contains the address of the memory location that is to be read from or stored into.","B");
        this.addQuestionEczacilik(q45);
        QuestionEczacilik q46 = new QuestionEczacilik("In virtual memory systems, Dynamic address translation","is the hardware necessary to implement paging","stores pages at a specific location on disk","is useless when swapping is used","is part of the operating system paging algorithm","is the hardware necessary to implement paging","B");
        this.addQuestionEczacilik(q46);
        QuestionEczacilik q47 = new QuestionEczacilik("Fragmentation of the file system","occurs only if the file system is used improperly","can always be prevented","can be temporarily removed by compaction","is a characteristic of all file systems","can be temporarily removed by compaction","B");
        this.addQuestionEczacilik(q47);
        QuestionEczacilik q48 = new QuestionEczacilik("A non-relocatable program is one which","cannot be made to execute in any area of storage other than the one designated for it at the time of its coding or translation.","consists of a program and relevant information for its relocation.","can itself performs the relocation of its address-sensitive portions.","all of the above","cannot be made to execute in any area of storage other than the one designated for it at the time of its coding or translation.","B");
        this.addQuestionEczacilik(q48);
        QuestionEczacilik q49 = new QuestionEczacilik("Which of the following are(is) Language Processor(s)","assembles","compilers","interpreters","All of the above","All of the above","B");
        this.addQuestionEczacilik(q49);
        QuestionEczacilik q50 = new QuestionEczacilik("In which addressing mode the effective address of the operand is the contents of a register specified in the instruction and after accessing the operand, the contents of this register is incremented to point to the next item in the list?","index addressing","indirect addressing","auto increment","auto decrement","auto increment","B");
        this.addQuestionEczacilik(q50);
        QuestionEczacilik q51 = new QuestionEczacilik("The memory allocation scheme subject to \"external\" fragmentation is","segmentation","swapping","pure demand paging","multiple contiguous fixed partitions","segmentation","I");
        this.addQuestionEczacilik(q51);
        QuestionEczacilik q52 = new QuestionEczacilik("While working with MS-DOS, which command will you use to transfer a specific file from one disk to another?","DISKCOPY","COPY","RENAME","FORMAT","COPY","I");
        this.addQuestionEczacilik(q52);
        QuestionEczacilik q53 = new QuestionEczacilik("What is the name of the operating system for the laptop computer called MacLite?","Windows","DOS","MS-DOS","OZ","OZ","I");
        this.addQuestionEczacilik(q53);
        QuestionEczacilik q54 = new QuestionEczacilik("In which addressing mode the contents of a register specified in the instruction are first decremented, and then these contents are used as the effective address of the operands?","index addressing","indirect addressing","auto increment","auto decrement","auto decrement","I");
        this.addQuestionEczacilik(q54);
        QuestionEczacilik q55 = new QuestionEczacilik("What is the name given to the values that are automatically provided by software to reduce keystrokes and improve a computer user's productivity?","Defined values","Fixed values","Default values","Special values","Default values","I");
        this.addQuestionEczacilik(q55);
        QuestionEczacilik q56 = new QuestionEczacilik("Page stealing","is a sign of an efficient system","is taking page frames from other working sets","should be the tuning goal","is taking larger disk spaces for pages paged out","is taking page frames from other working sets","I");
        this.addQuestionEczacilik(q56);
        QuestionEczacilik q57 = new QuestionEczacilik("In MS-DOS 5.0, which is the number that acts as a code to uniquely identify the software product?","MS","DOS","MS DOS","5.0","5.0","I");
        this.addQuestionEczacilik(q57);
        QuestionEczacilik q58 = new QuestionEczacilik("Bug means","A logical error in a program","A difficult syntax error in a program","Documenting programs using an efficient documentation tool","All of the above","A logical error in a program","I");
        this.addQuestionEczacilik(q58);
        QuestionEczacilik q59 = new QuestionEczacilik("Memory management is :","not used in modern operating system","replaced with virtual memory on current systems","not used on multiprogramming systems","critical for even the simplest operating systems","critical for even the simplest operating systems","I");
        this.addQuestionEczacilik(q59);
        QuestionEczacilik q60 = new QuestionEczacilik("The initial value of the semaphore that allows only one of the many processes to enter their critical sections, is","8","1","16","0","1","I");
        this.addQuestionEczacilik(q60);
        QuestionEczacilik q61 = new QuestionEczacilik("The Register - to - Register (RR) instructions","have both their operands in the main store.","which perform an operation on a register operand and an operand which is located in the main store, generally leaving the result in the register, except in the case of store operation when it is also written into the specified storage location.","which perform indicated operations on two fast registers of the machine and leave the result in one of the registers.","all of the above","which perform indicated operations on two fast registers of the machine and leave the result in one of the registers.","I");
        this.addQuestionEczacilik(q61);
        QuestionEczacilik q62 = new QuestionEczacilik("A page fault","is an error is a specific page","occurs when a program accesses a page of memory","is an access to a page not currently in memory","is a reference to a page belonging to another program","is an access to a page not currently in memory","I");
        this.addQuestionEczacilik(q62);
        QuestionEczacilik q63 = new QuestionEczacilik("An algorithm is best described as","A computer langage","A step by step procedure for solving a problem","A branch of mathematics","All of the above","A step by step procedure for solving a problem","I");
        this.addQuestionEczacilik(q63);
        QuestionEczacilik q64 = new QuestionEczacilik("The process of transferring data intended for a peripheral device into a disk (or intermediate store) so that it can be transferred to peripheral at a more convenient time or in bulk, is known as","multiprogramming","spooling","caching","virtual programming","spooling","I");
        this.addQuestionEczacilik(q64);
        QuestionEczacilik q65 = new QuestionEczacilik("Block caches or buffer caches are used","to improve disk performance","to handle interrupts","to increase the capacity of the main memory","to speed up main memory read operation","to improve disk performance","I");
        this.addQuestionEczacilik(q65);
        QuestionEczacilik q66 = new QuestionEczacilik("Which of the following statements is false?","a small page size causes large page tables","internal fragmentation is increased with small pages","a large page size causes instructions and data that will not be referenced brought into primary storage","I/O transfers are more efficient with large pages","internal fragmentation is increased with small pages","I");
        this.addQuestionEczacilik(q66);
        QuestionEczacilik q67 = new QuestionEczacilik("The action of parsing the source program into the proper syntactic classes is known as","syntax analysis","lexical analysis","interpretation analysis","general syntax analysis","lexical analysis","I");
        this.addQuestionEczacilik(q67);
        QuestionEczacilik q68 = new QuestionEczacilik("Which, of the following is not true about the description of a decision table?","A decision table is easy to modify","A decision table is directly understood by the computer","A decision table is easy to understand","All of the above","A decision table is directly understood by the computer","I");
        this.addQuestionEczacilik(q68);
        QuestionEczacilik q69 = new QuestionEczacilik("Trojan-Horse programs","are legitimate programs that allow unauthorized access","do not usually work","are hidden programs that do not show up on the system","usually are immediately discovered","are legitimate programs that allow unauthorized access","I");
        this.addQuestionEczacilik(q69);
        QuestionEczacilik q70 = new QuestionEczacilik("When did IBM release the first version of disk operating system DOS version 1.0?","1981","1982","1983","1984","1981","I");
        this.addQuestionEczacilik(q70);
        QuestionEczacilik q71 = new QuestionEczacilik("Which of the following is false about disk when compared to main memory?","non-volatile","longer storage capacity","lower price per bit","faster","faster","I");
        this.addQuestionEczacilik(q71);
        QuestionEczacilik q72 = new QuestionEczacilik("Producer consumer problem can be solved using","semaphores","event counters","monitors","all of the above","all of the above","I");
        this.addQuestionEczacilik(q72);
        QuestionEczacilik q73 = new QuestionEczacilik("Most of the microcomputer's operating systems like Apple DOS, MS DOS and PC DOS etc. are called disk operating systems because","they are memory resident","they are initially stored on disk","they are available on magnetic tapes","they are partly in primary memory and partly on disk","they are initially stored on disk","I");
        this.addQuestionEczacilik(q73);
        QuestionEczacilik q74 = new QuestionEczacilik("The CPU, after receiving an interrupt from an I/O device","halts for a predetermined time","hands over control of address bus and data bus to the interrupting device","branches off to the interrupt service routine immediately","branches off to the interrupt service routine after completion of the current instruction","branches off to the interrupt service routine after completion of the current instruction","I");
        this.addQuestionEczacilik(q74);
        QuestionEczacilik q75 = new QuestionEczacilik("Seeks analysis","is used for analyzing paging problems","is used for analyzing control-unit busy problems","is only shown on real-time displays","is used for analyzing device busy problems","is used for analyzing device busy problems","I");
        this.addQuestionEczacilik(q75);
        QuestionEczacilik q76 = new QuestionEczacilik("Which is a permanent database in the general model of compiler?","Literal Table","Identifier Table","Terminal Table","Source code","Terminal Table","I");
        this.addQuestionEczacilik(q76);
        QuestionEczacilik q77 = new QuestionEczacilik("What is the name of the technique in which the operating system of a computer executes several programs concurrently by switching back and forth between them?","Partitioning","Multitasking","Windowing","Paging","Multitasking","I");
        this.addQuestionEczacilik(q77);
        QuestionEczacilik q78 = new QuestionEczacilik("Operating system","links a program with the subroutines it references","provides a layered, user-friendly interface","enables the programmer to draw a flowchart","all of the above","provides a layered, user-friendly interface","I");
        this.addQuestionEczacilik(q78);
        QuestionEczacilik q79 = new QuestionEczacilik("Software that measures, monitors, analyzes, and controls real-world events is called:","system software","real-time software","scientific software","business software","real-time software","I");
        this.addQuestionEczacilik(q79);
        QuestionEczacilik q80 = new QuestionEczacilik("The details of all external symbols and relocation formation (relocation list or map) is provided to linker by","Macro processor","Translator","Loader","Editor","Translator","I");
        this.addQuestionEczacilik(q80);
        QuestionEczacilik q81 = new QuestionEczacilik("The macro processor must perform","recognize macro definitions and macro calls","save the macro definitions","expand macros calls and substitute arguments","all of the above","all of the above","I");
        this.addQuestionEczacilik(q81);
        QuestionEczacilik q82 = new QuestionEczacilik("A development strategy whereby the executive control modules of a system are coded and tested first, is known as","Bottom-up development","Top-down development","Left-Right development","All of the above","Top-down development","I");
        this.addQuestionEczacilik(q82);
        QuestionEczacilik q83 = new QuestionEczacilik("Which of the following is helpful in evaluating applications software what will best suit your needs?","recommendations by other users","computer magazines","objective software reviews","all of the above","all of the above","I");
        this.addQuestionEczacilik(q83);
        QuestionEczacilik q84 = new QuestionEczacilik("What problem is solved by Dijkstra's banker's algorithm?","mutual exclusion","deadlock recovery ","deadlock avoidance","cache coherence","deadlock avoidance","I");
        this.addQuestionEczacilik(q84);
        QuestionEczacilik q85 = new QuestionEczacilik("The dispatcher","actually schedules the tasks into the processor","puts tasks in I/O wait","is always small and simple","never changes task priorities","actually schedules the tasks into the processor","I");
        this.addQuestionEczacilik(q85);
        QuestionEczacilik q86 = new QuestionEczacilik("System programs such as Compilers are designed so that they are","reenterable","non reusable","serially usable","recursive","reenterable","I");
        this.addQuestionEczacilik(q86);
        QuestionEczacilik q87 = new QuestionEczacilik("IBM released its first PC in 1981. Can you name the operating system which was most popular at that time?","MS-DOS","PC-DOS","OS/360","CP/M","CP/M","I");
        this.addQuestionEczacilik(q87);
        QuestionEczacilik q88 = new QuestionEczacilik("If the number of bits in a virtual address of a program is 16 and the page size is 0.5 K bytes, the number of pages in the virtual address space is","16","32","64","128","128","I");
        this.addQuestionEczacilik(q88);
        QuestionEczacilik q89 = new QuestionEczacilik("Which table is a permanent database that has an entry for each terminal symbol.","Terminal table","Reductions","Identifier table","Literal table","Terminal table","I");
        this.addQuestionEczacilik(q89);
        QuestionEczacilik q90 = new QuestionEczacilik("The function(s) of the Syntax phase is(are)","to recognize the major constructs of the language and to call the appropriate action routines that will generate the intermediate form or matrix for these constructs.","to build a literal table and an identifier table","to build a uniform symbol table","to parse the source program into the basic elements or tokens of the language.","to recognize the major constructs of the language and to call the appropriate action routines that will generate the intermediate form or matrix for these constructs.","I");
        this.addQuestionEczacilik(q90);
        QuestionEczacilik q91 = new QuestionEczacilik("Swapping","works best with many small partitions","allows many programs to use memory simultaneously","allows each program in turn to use the memory","does not work with overlaying33","allows each program in turn to use the memory","I");
        this.addQuestionEczacilik(q91);
        QuestionEczacilik q92 = new QuestionEczacilik("A disk scheduling algorithm in an operating system causes the disk arm to move back and forth across the disk surface in order to service all requests in its path. This is a","First come first served","Shortest Seek Time First (SSTE)","Scan","FIFO","Scan ","I");
        this.addQuestionEczacilik(q92);
        QuestionEczacilik q93 = new QuestionEczacilik("A translator is best described as","an application software","a system software","a hardware component","all of the above","a system software","I");
        this.addQuestionEczacilik(q93);
        QuestionEczacilik q94 = new QuestionEczacilik("Data encryption","is mostly used by public networks","is mostly used by financial networks","cannot be used by private installations","is not necessary, since data cannot be intercepted","is mostly used by financial networks","I");
        this.addQuestionEczacilik(q94);
        QuestionEczacilik q95 = new QuestionEczacilik("What is the name given to the process of initializing a microcomputer with its operating system?","Cold booting","Booting","Warm booting","Boot recording","Booting","I");
        this.addQuestionEczacilik(q95);
        QuestionEczacilik q96 = new QuestionEczacilik("The function(s) of the Storage Assignment is (are)","to assign storage to all variables referenced in the source program.","to assign storage to all temporary locations that are necessary for intermediate results","to assign storage to literals, and to ensure that the storage is allocate and appropriate locations are initialized.","all of the above","all of the above","I");
        this.addQuestionEczacilik(q96);
        QuestionEczacilik q97 = new QuestionEczacilik("A Processor","is a device that performs a sequence of operations specified by instructions in memory.","is the device where information is stored","is a sequence of instructions","is typically characterized by interactive processing and time of the CPU's time to allow quick response to each user","is a device that performs a sequence of operations specified by instructions in memory","I");
        this.addQuestionEczacilik(q97);
        QuestionEczacilik q98 = new QuestionEczacilik("With MS-DOS which command will divide the surface of the blank floppy disk into sectors and assign a unique address to each one?","FORMAT command","FAT command","VER command","CHKDSK command","FORMAT command","I");
        this.addQuestionEczacilik(q98);
        QuestionEczacilik q99 = new QuestionEczacilik("Multiprogramming","is a method of memory allocation by which the program is subdivided into equal portions, or pages and core is subdivided into equal portions or blocks.","consists of those addresses that may be generated by a processor during execution of a computation","is a method of allocating processor time.","allows multiple programs to reside in separate areas of core at the time","allows multiple programs to reside in separate areas of core at the time","I");
        this.addQuestionEczacilik(q99);
        QuestionEczacilik q100 = new QuestionEczacilik("A translator which reads an entire programme written in a high level language and converts it into machine language code is:","assembler","translator","compiler","system software","compiler","I");
        this.addQuestionEczacilik(q100);
        QuestionEczacilik q101=new QuestionEczacilik("If the displayed system time and date is wrong, you can reset it using","Write","Calendar","Control Panel","Action Center","Control Panel","E");
        this.addQuestionEczacilik(q101);
        QuestionEczacilik q102=new QuestionEczacilik("You should save your computer from","virus","worms","malwares","all of the above","all of the above","E");
        this.addQuestionEczacilik(q102);
        QuestionEczacilik q103=new QuestionEczacilik("World Wide Web is being standardized by ","Worldwide INC","W3C","World Wide Consortium","World Wide Web Standard","W3C","E");
        this.addQuestionEczacilik(q103);
        QuestionEczacilik q104=new QuestionEczacilik("Which of the following is a program group?","Accessories","MS WORD","Paint","SharePoint","Accessories","E");
        this.addQuestionEczacilik(q104);
        QuestionEczacilik q105= new QuestionEczacilik("Which OS does not support more than one program at a time?","DOS","Linux","Windows","Unix","DOS","E");
        this.addQuestionEczacilik(q105);
        QuestionEczacilik q106= new QuestionEczacilik("Linus is ","Open source","Windows","Costly","MAC","Open source","E");
        this.addQuestionEczacilik(q106);
        QuestionEczacilik q107=new QuestionEczacilik("Which one is not an OS","P11","OS/2","Windows","Unix","P11","E");
        this.addQuestionEczacilik(q107);
        QuestionEczacilik q108= new QuestionEczacilik("Which one is not an multitasking OS","Windows","Linux","Win NT","DOS","DOS","E");
        this.addQuestionEczacilik(q108);
        QuestionEczacilik q109= new QuestionEczacilik("A user interface that is easy to use is","user happy","user friendly","user simple","none of these","user friendly","E");
        this.addQuestionEczacilik(q109);
        QuestionEczacilik q110= new QuestionEczacilik("What is the function of radio button?","To select multiple option","To select single option","To select all option","All of above","To select single option","E");
        this.addQuestionEczacilik(q110);
        QuestionEczacilik q111= new QuestionEczacilik("Which command is used to display contents of text file in DOS?","copy con","copy","type","dir","type","E");
        this.addQuestionEczacilik(q111);
        QuestionEczacilik q112= new QuestionEczacilik("Essential file of MSDOS boot disk is:","COMMAND.COM","START.COM","TREE.COM","VER.COM","COMMAND.COM","E");
        this.addQuestionEczacilik(q112);
        QuestionEczacilik q113= new QuestionEczacilik("Which command is used to see version of OS?","vol","version","ver","volume","ver","E");
        this.addQuestionEczacilik(q113);
        QuestionEczacilik q114= new QuestionEczacilik("Which of the following are loaded in safe mode?","Keyboard Driver","Mouse Driver","VGA Driver","ALL","ALL","E");
        this.addQuestionEczacilik(q114);
        QuestionEczacilik q115=new QuestionEczacilik("The bankers alorithm is used to","to rectify deadlock","to detect deadlock","to prevent deadlock","to slow deadlock","to prevent deadlock","E");
        this.addQuestionEczacilik(q115);
        QuestionEczacilik q116= new QuestionEczacilik("Which of the following is drop down list?","List","Combo Box","Text Area","None","Combo Box","E");
        this.addQuestionEczacilik(q116);
        QuestionEczacilik q117=new QuestionEczacilik("A page fault occurs when","the deadlock happens","the segmentation starts","the page is found in memory","the page is not found in memory","the page is not found in memory","E");
        this.addQuestionEczacilik(q117);
        QuestionEczacilik q118= new QuestionEczacilik("Taskbar is used for","Navigation","Switching programs","Start a program","All of above","All of above","E");
        this.addQuestionEczacilik(q118);
        QuestionEczacilik q119= new QuestionEczacilik("What is Dr.Watson?","IT Expert","Diagnosis Tool","Surgeon","None","IT Expert","E");
        this.addQuestionEczacilik(q119);
        QuestionEczacilik q120= new QuestionEczacilik("The command used to create logical drive for specific location of disk","FDisk","Format","Subst","All of above","Subst","E");
        this.addQuestionEczacilik(q120);
        QuestionEczacilik q121= new QuestionEczacilik("Running multiple programs at the same time is called","Multitasking","Background Tasking","Foreground Tasking","None of the above","Multitasking","E");
        this.addQuestionEczacilik(q121);
        QuestionEczacilik q122= new QuestionEczacilik("Page stealing","is an sign of an efficient system","Is taking page frame from other working sets","Should be the turning goal","Is taking layer disk space for page in page out","Is taking page frame from other working sets","E");
        this.addQuestionEczacilik(q122);
        QuestionEczacilik q123= new QuestionEczacilik("What do you mean by dialog box?","Interactive message box","Group of options","Set of controls","All of the above","All of the above","E");
        this.addQuestionEczacilik(q123);
        QuestionEczacilik q124= new QuestionEczacilik("Dial up connection allows you to","Connect ISP","Internet","Server","All of above","Connect ISP","E");
        this.addQuestionEczacilik(q124);
        QuestionEczacilik q125= new QuestionEczacilik("Which is not a system tool?","Folder","Backup","Scandisk","Format","Folder","E");
        this.addQuestionEczacilik(q125);
        QuestionEczacilik q126= new QuestionEczacilik("Scandisk ","Checks the disk","Give information about disk","Run from DOS mode","All of the above","All of the above","E");
        this.addQuestionEczacilik(q126);
        QuestionEczacilik q127= new QuestionEczacilik("Batch file is used to","Run program","Show the contents","run commands automatically","All of above","All of above","E");
        this.addQuestionEczacilik(q127);
        QuestionEczacilik q128= new QuestionEczacilik("Which of the following is not process states?","New","Ready","Running","Finished","Finished","E");
        this.addQuestionEczacilik(q128);
        QuestionEczacilik q129= new QuestionEczacilik("We can start the application from?","Log Off","Network Place","Recycle Bin","Run","Run","E");
        this.addQuestionEczacilik(q129);
        QuestionEczacilik q130= new QuestionEczacilik("What you type at the DOS command prompt to return back to windows?","Command","Exit","Quit","Return","Exit","E");
        this.addQuestionEczacilik(q130);
        QuestionEczacilik q131= new QuestionEczacilik("Which of the following is the part of the operating system?","Cell","FAT","Kernel","Disk","Kernel","E");
        this.addQuestionEczacilik(q131);
        QuestionEczacilik q132= new QuestionEczacilik("Sleep is a good mode to use because","It saves power which in turn is saving money","It makes compuer fresh after it wakes up","It consumes low battery when you start it again","All of above","It saves power which in turn is saving money","E");
        this.addQuestionEczacilik(q132);
        QuestionEczacilik q133= new QuestionEczacilik("The operating feature that integrates the file created in different application into WebPages","Web integration","Internet integration","Intranet integration","Hypertext integration","Web integration","E");
        this.addQuestionEczacilik(q133);
        QuestionEczacilik q134= new QuestionEczacilik("What hole will allocates in Worst-Fit algorithm of memory management?","It allocates the smaller hole than required memory hole","It allocates the smallest hole from the available memory holes","It allocates the largest hole from the available memory holes","It allocates the exact same size memory hole","It allocates the largest hole from the available memory holes","E");
        this.addQuestionEczacilik(q134);
        QuestionEczacilik q135= new QuestionEczacilik("BIOS is used by","Operating system","Compiler","Interpreter","Application software","Operating system","E");
        this.addQuestionEczacilik(q135);
        QuestionEczacilik q136= new QuestionEczacilik("Commonly network of network is called","MS Word","MS Excel","Internet","MS Access","Internet","E");
        this.addQuestionEczacilik(q136);
        QuestionEczacilik q137= new QuestionEczacilik("Find can be used to","Locate a program","Locate a document","Locate a network computer","All of above","All of above","E");
        this.addQuestionEczacilik(q137);
        QuestionEczacilik q138= new QuestionEczacilik("Which of the following is the allocation method of a disk space?","Contiguous allocation","Linked allocation","Indexed allocation","All of the Above","All of the Above","E");
        this.addQuestionEczacilik(q138);
        QuestionEczacilik q139= new QuestionEczacilik("When you cut or copy the text or picture, it stores temporarily in the","File","Clipboard","Icon","All of above","Clipboard","E");
        this.addQuestionEczacilik(q139);
        QuestionEczacilik q140= new QuestionEczacilik("A tiny dot of light on the monitor is called","Silicon chip","Optical illusion","Icon","Pixel","Pixel","E");
        this.addQuestionEczacilik(q140);
        QuestionEczacilik q141= new QuestionEczacilik("Who is called a supervisor of computer activity?","Memory","Operating System","I/O Devices","Control Unit","Operating System","E");
        this.addQuestionEczacilik(q141);
        QuestionEczacilik q142= new QuestionEczacilik("Operating System manages","Memory","Processor","I/O devices","All of the above","All of the above","E");
        this.addQuestionEczacilik(q142);
        QuestionEczacilik q143= new QuestionEczacilik("Which of the following concept is best to preventing page faults?","Paging","The working set","Hit ratios","Address location resolution","Paging","E");
        this.addQuestionEczacilik(q143);
        QuestionEczacilik q144= new QuestionEczacilik("Which is not a valid property for attribute setting?","C","S","H","R","C","E");
        this.addQuestionEczacilik(q144);
        QuestionEczacilik q145= new QuestionEczacilik("Virtual memory typically located on","RAM","CPU","Flash Card","Hard Drive","Hard Drive","E");
        this.addQuestionEczacilik(q145);
        QuestionEczacilik q146= new QuestionEczacilik("Tree structure displays the","File only","Directory only","File and directory name","None of above","File and directory name","E");
        this.addQuestionEczacilik(q146);
        QuestionEczacilik q147= new QuestionEczacilik("Press ____ key while booting to display Advanced Boot Menu","F8","F5","Del","F2","F8","E");
        this.addQuestionEczacilik(q147);
        QuestionEczacilik q148= new QuestionEczacilik("Which operating system uses short file names?","Windows","Unix","DOS","MAC","DOS","E");
        this.addQuestionEczacilik(q148);
        QuestionEczacilik q149= new QuestionEczacilik("What do you mean by Memory Compaction?","Combine multiple equal memory holes into one big hole","Combine multiple small memory holes into one big hole","Divide big memory hole into small holes","Divide memory hole by 2","Combine multiple small memory holes into one big hole","E");
        this.addQuestionEczacilik(q149);
        QuestionEczacilik q150= new QuestionEczacilik("Copying a process from memory to disk to allow space for other processes is called","Swapping","Deadlock","Demand Paging","Page Fault","Swapping","E");
        this.addQuestionEczacilik(q150);

        }

public void addQuestionEczacilik(QuestionEczacilik quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());
        values.put(KEY_CAT,quest.getCATEGORY());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
        }

private void addQuestionsIktisat() {

        QuestionIktisat q1 = new QuestionIktisat("From what location are the 1st computer instructions available on boot up?","ROM BIOS","CPU","boot.ini","CONFIG.SYS","ROM BIOS","B");
        this.addQuestionIktisat(q1);
        QuestionIktisat q2 = new QuestionIktisat("What could cause a fixed disk error.","No-CD installed","bad ram","slow processor","Incorrect CMOS settings","Incorrect CMOS settings","B");
        this.addQuestionIktisat(q2);
        QuestionIktisat q3 = new QuestionIktisat("Missing slot covers on a computer can cause?","over heat","power surges","EMI","incomplete path for ESD","over heat","B");
        this.addQuestionIktisat(q3);
        QuestionIktisat q4 = new QuestionIktisat("When installing PCI NICS you can check the IRQ availability by looking at","dip switches","CONFIG.SYS","jumper settings","motherboard BIOS","motherboard BIOS","B");
        this.addQuestionIktisat(q4);
        QuestionIktisat q5 = new QuestionIktisat("With respect to a network interface card, the term 10/100 refers to","protocol speed","a fiber speed","megabits per seconds","minimum and maximum server speed","megabits per seconds","B");
        this.addQuestionIktisat(q5);
        QuestionIktisat q6 = new QuestionIktisat("Which Motherboard form factor uses one 20 pin connector","ATX","All of the above","BABY AT","AT","ATX","B");
        this.addQuestionIktisat(q6);
        QuestionIktisat q7 = new QuestionIktisat("A hard disk is divided into tracks which are further subdivided into:","clusters","sectors","vectors","heads","sectors","B");
        this.addQuestionIktisat(q7);
        QuestionIktisat q8 = new QuestionIktisat("A wrist grounding strap contains which of the following:","Surge protector","Capacitor","Voltmeter","Resistor","Resistor","B");
        this.addQuestionIktisat(q8);
        QuestionIktisat q9 = new QuestionIktisat("Which standard govern parallel communications?","RS232","RS-232a","CAT 5","IEEE 1284","IEEE 1284","B");
        this.addQuestionIktisat(q9);
        QuestionIktisat q10 = new QuestionIktisat("In laser printer technology, what happens during the conditioning stage?","The corona wire places a uniform positive charge on the paper","A uniform negative charge is placed on the photosensitive drum","A uniform negative charge is placed on the toner","All of the above","A uniform negative charge is placed on the photosensitive drum","B");
        this.addQuestionIktisat(q10);
        QuestionIktisat q11 = new QuestionIktisat("What product is used to clean smudged keys on a keyboard?","TMC solvent","Silicone spray","Denatured alcohol","All-purpose cleaner","All-purpose cleaner","B");
        this.addQuestionIktisat(q11);
        QuestionIktisat q12 = new QuestionIktisat("ESD would cause the most damage to which component?","Power supply","Expansion board","Monitor","Keyboard","Expansion board","B");
        this.addQuestionIktisat(q12);
        QuestionIktisat q13 = new QuestionIktisat("To view any currently running Terminate Stay Resident (TSR's) programs you could type:","Memory","MEM","Memmaker","SYS /M","MEM","B");
        this.addQuestionIktisat(q13);
        QuestionIktisat q14 = new QuestionIktisat("Which type of system board is the MOST likely candidate for processor upgrading if you want maximum performance and future compatibility?","ML","PCI","EISA","ISA","PCI","B");
        this.addQuestionIktisat(q14);
        QuestionIktisat q15 = new QuestionIktisat("Which peripheral port provides the FASTEST throughput to laser printers?","RS-232","SCSI","Parallel","Serial","Parallel","B");
        this.addQuestionIktisat(q15);
        QuestionIktisat q16 = new QuestionIktisat("The mouse pointer moves erratically, what is the possible cause? The mouse","ball is dirty","is not connected","driver is not installed properly","has an incorrect IRQ setting","ball is dirt","B");
        this.addQuestionIktisat(q16);
        QuestionIktisat q17 = new QuestionIktisat("Voltage is measured:","in parallel","in series","after breaking the circuit","after checking resistance","in parallel","B");
        this.addQuestionIktisat(q17);
        QuestionIktisat q18 = new QuestionIktisat("Your customer tells you the print quality of their dot matrix printer is light then dark. Which of the following could cause the problem.","Paper slippage","Improper ribbon advancement","Paper thickness","Head position","Improper ribbon advancement","B");
        this.addQuestionIktisat(q18);
        QuestionIktisat q19 = new QuestionIktisat("The 34-pin connection on an I/O card is for?","Floppy drive","SCSI drive","IDE drive","Zip drive","Floppy drive","B");
        this.addQuestionIktisat(q19);
        QuestionIktisat q20 = new QuestionIktisat("The terms \"red book\", \"yellow book\", and \"orange book\" refer to:","SCSI","ide","floppy drive technology","CD-ROM standards","CD-ROM standards","B");
        this.addQuestionIktisat(q20);
        QuestionIktisat q21 = new QuestionIktisat("On the 16-bit ISA bus, IRQ2 is elevated to which higher level Interrupt?","9","11","13","15","9","B");
        this.addQuestionIktisat(q21);
        QuestionIktisat q22 = new QuestionIktisat("To view any currently running Terminate Stay Resident (TSR's) programs you could type:","Memory","MEM","SYS/M","Memmaker","MEM","B");
        this.addQuestionIktisat(q22);
        QuestionIktisat q23 = new QuestionIktisat("Which part of the laser printer should NOT be exposed to sunlight?","Transfer corona assembly","PC drum","Primary corona wire","PC drumPrimary corona wire","PC drum","B");
        this.addQuestionIktisat(q23);
        QuestionIktisat q24 = new QuestionIktisat("After doing a low-level format, what would be the next step in configuring the hard drive in a system?","Format DOS partition","Install operating system","Configure DMA channel and back-up interrupt","Partition had disk","Format DOS partition","B");
        this.addQuestionIktisat(q24);
        QuestionIktisat q25 = new QuestionIktisat("Resistance is measured in ?","Volts","Amps","Watts","Ohms","Ohms","B");
        this.addQuestionIktisat(q25);
        QuestionIktisat q26 = new QuestionIktisat("What command is used to reset a MODEM when using the AT Command Set?","ATR","ATZ","DTR","DCE","ATZ","B");
        this.addQuestionIktisat(q26);
        QuestionIktisat q27 = new QuestionIktisat("When installing a SCSI CD-ROM drive, you must set the CD-ROM SCSI adapter to:","B0007","An unused SCSI address","The same address as the SCSI device before the CD-ROM","SCSI ID=1","An unused SCSI address","B");
        this.addQuestionIktisat(q27);
        QuestionIktisat q28 = new QuestionIktisat("Pick the correct choice for the 80386SXCPU.","16 bit word size, 16 bit data path","32 bit word size, 16 bit data path","8 bit word size, 32 bit data path","32 bit word size, 8 bit data path","32 bit word size, 16 bit data path","B");
        this.addQuestionIktisat(q28);
        QuestionIktisat q29 = new QuestionIktisat("In Inkjet technology the droplets of ink are deflected by?","multi directional nozzles","electronically charged plates","high pressure plates","electro static absorbtion","multi directional nozzles","B");
        this.addQuestionIktisat(q29);
        QuestionIktisat q30 = new QuestionIktisat("What tool is used to test serial and parallel ports?","high volt probe","cable scanner","loop backs (wrap plugs)","sniffer","loop backs (wrap plugs)","B");
        this.addQuestionIktisat(q30);
        QuestionIktisat q31 = new QuestionIktisat("ESD would cause the most damage to which component?","Power supply","Expansion board","Monitor","Keyboard","Expansion board","B");
        this.addQuestionIktisat(q31);
        QuestionIktisat q32 = new QuestionIktisat("What is the highest binary number that can be referred to on a three position jumper block?","4","6","F","1","1","B");
        this.addQuestionIktisat(q32);
        QuestionIktisat q33 = new QuestionIktisat("What voltage does a Pentium system use?","+12 volts","+ 5 volts","+ 5 volts","+3.3 volts","+3.3 volts","B");
        this.addQuestionIktisat(q33);
        QuestionIktisat q34 = new QuestionIktisat("A numeric error code check: A 17xx indicates a problem with:","CMOS","ROM BIOS","DMA controller","hard drive or controller","hard drive or controller","B");
        this.addQuestionIktisat(q34);
        QuestionIktisat q35 = new QuestionIktisat("Which provides the fastest access to large video files?","Optical drives","IDE hard drives","SCSI hard drives","EIDE hard drives","SCSI hard drives","B");
        this.addQuestionIktisat(q35);
        QuestionIktisat q36 = new QuestionIktisat("A 25-pin female connector on the back of your computer will typically be:","Serial port 1","A parallel port","Docking","COM2 port","A parallel port","B");
        this.addQuestionIktisat(q36);
        QuestionIktisat q37 = new QuestionIktisat("You were installing an application in Windows 95, and the computer crashes, what do you do?","press alt + Ctrl + delete, twice","press alt + Ctrl + delete, and end task","press the reset button on the computer","turn off computer and boot from a floppy disk","turn off computer and boot from a floppy disk","B");
        this.addQuestionIktisat(q37);
        QuestionIktisat q38 = new QuestionIktisat("RS-232 is a standard that applies to:","serial ports","parallel ports","game ports","networks","serial ports","B");
        this.addQuestionIktisat(q38);
        QuestionIktisat q39 = new QuestionIktisat("You just installed a new IDE hard drive, but your system BIOS will not recognize the new drive, what should you check first.","cable sequence","jumpers on the hard drive","drivers that need to be loaded","hard drive manufacturer web site information","drivers that need to be loaded","B");
        this.addQuestionIktisat(q39);
        QuestionIktisat q40 = new QuestionIktisat("During boot-up, the memory test:","Is a superfluous step that should be ignored","Checks and verifies that contiguous memory is installed","Is an operational error","Displays what memory is installed, but nothing else","Checks and verifies that contiguous memory is installed","B");
        this.addQuestionIktisat(q40);
        QuestionIktisat q41 = new QuestionIktisat("What is the best ground for a conductive work bench?","AC outlet","Ground to bend","To another device","Chassis ground","AC outlet","B");
        this.addQuestionIktisat(q41);
        QuestionIktisat q42 = new QuestionIktisat("Topically, how many type III PC cards can you insert in a laptop","1","2","3","4","1","B");
        this.addQuestionIktisat(q42);
        QuestionIktisat q43 = new QuestionIktisat("What is the first thing you could do to check for damage to a printer after receiving it?","Run MSD diagnostics","Attach it to a PC and print something","Check the cables","Unbox it and examine it for physical damage","Unbox it and examine it for physical damage","B");
        this.addQuestionIktisat(q43);
        QuestionIktisat q44 = new QuestionIktisat("You have a system that periodically locks up. You have ruled out software, and now suspect that it is hardware. What should you do first that could help you narrow it down to the component at fault?","rotate the RAM","replace the RAM","replace the level 2 cache SIMM","disable the CPU cache in CMOS","disable the CPU cache in CMOS","B");
        this.addQuestionIktisat(q44);
        QuestionIktisat q45 = new QuestionIktisat("What's the best way to protect your hard drive data?","regular backups","periodically defrag it","run chkdsk at least once a week","run scandisk at least once a week","regular backups","B");
        this.addQuestionIktisat(q45);
        QuestionIktisat q46 = new QuestionIktisat("On a dot matrix printer, you should never lubricate which part?","carriage rails","printhead pins","paper advance bearings","carriage bearings","printhead pins","B");
        this.addQuestionIktisat(q46);
        QuestionIktisat q47 = new QuestionIktisat("How many devices can be used on a single SCSI bus? Keep in mind that the SCSI host adapter counts as a device.","1","8","20","10","8","B");
        this.addQuestionIktisat(q47);
        QuestionIktisat q48 = new QuestionIktisat("Match the device driver HIMEM.SYS to its operation.","Supports (ANSI) terminal emulation","Manages the use of extended memory","Uses expanded memory on a 80386 processor","Supports code page switching","Manages the use of extended memory","B");
        this.addQuestionIktisat(q48);
        QuestionIktisat q49 = new QuestionIktisat("_____ help prevent power surges.","Surge suppressor","Spike protector","UPS system","High-grade multi-meter","Surge suppressor","B");
        this.addQuestionIktisat(q49);
        QuestionIktisat q50 = new QuestionIktisat("The digital multimeter is set for DC, Ohm and 20k. You will read _____ while measuring a good 2 amp fuse.","0.00","0.02","0.20","2.00","0.00","B");
        this.addQuestionIktisat(q50);
        QuestionIktisat q51 = new QuestionIktisat("An anti static strap uses a small _____ to make sure you do not become the least path of resistance to the ground?","capacitor","diode","transistor","resistor","resistor","E");
        this.addQuestionIktisat(q51);
        QuestionIktisat q52 = new QuestionIktisat("If the memory slots have 30 pins then the chip is a?","DIMM","SIMM","SDRAM","All of the above","SIMM","E");
        this.addQuestionIktisat(q52);
        QuestionIktisat q53 = new QuestionIktisat("Laser Jet printer speeds are measured in pages per minute (ppm) what do we use to measure dot-matrix printers?","lines per inch","lines per sheet","characters per inch","characters per second","characters per second","E");
        this.addQuestionIktisat(q53);
        QuestionIktisat q54 = new QuestionIktisat("Which values are held in CMOS for the hard drive","size (heads, cylinders, sectors)","IRQ","Free space","Virus alert","size (heads, cylinders, sectors)","E");
        this.addQuestionIktisat(q54);
        QuestionIktisat q55 = new QuestionIktisat("Which of the following would be a logical first step in troubleshooting a PC?","Check the computer CMOS","Define the circumstances of the problem","Call the vendor","Define what applications are being used","Define the circumstances of the problem","E");
        this.addQuestionIktisat(q55);
        QuestionIktisat q56 = new QuestionIktisat("Which DOS driver is used to emulate expanded memory?","Himem.sys","EMM386.exe","Mem386.sys","Ramdrive.sys","EMM386.exe","E");
        this.addQuestionIktisat(q56);
        QuestionIktisat q57 = new QuestionIktisat("For a Macintosh to print successfully, the System Folder must contain:","File sharing software","A printer enabler","The apple Garamond font set","A printer driver","A printer driver","E");
        this.addQuestionIktisat(q57);
        QuestionIktisat q58 = new QuestionIktisat("Which component must be vacuumed or replaced during preventative maintenance on a laser printer?","Scanning mirror","Toner cartridge","Ozone filter","All of the above","Ozone filter","E");
        this.addQuestionIktisat(q58);
        QuestionIktisat q59 = new QuestionIktisat("Which device uses a DMA channel?","Modem","Network Card","Sound Card","All of the above","Sound Card","E");
        this.addQuestionIktisat(q59);
        QuestionIktisat q60 = new QuestionIktisat("When is the risk for electrostatic discharge the greatest?","Day time","High humidity","Low humidity","Night time","Low humidity","E");
        this.addQuestionIktisat(q60);
        QuestionIktisat q61 = new QuestionIktisat("A modem could be attached to which port?","Parallel port","ASYNC port","Keyboard connector","Video port","Parallel port","E");
        this.addQuestionIktisat(q61);
        QuestionIktisat q62 = new QuestionIktisat("What device prevents power interruptions, resulting in corrupted data?","Battery back-up unit","Surge protector","Multiple SIMMs strips","Data guard system","Battery back-up unit","E");
        this.addQuestionIktisat(q62);
        QuestionIktisat q63 = new QuestionIktisat("SCSI must be terminated with?","Dip switch","Resistor","BNC","All of the above","Resistor","E");
        this.addQuestionIktisat(q63);
        QuestionIktisat q64 = new QuestionIktisat("In a computer with an eide adapter, where should you connect an ATA CD-ROM drive?","on the floppy bus","on the primary IDE","on the secondary IDE","on the SCSI bus","on the secondary IDE","E");
        this.addQuestionIktisat(q64);
        QuestionIktisat q65 = new QuestionIktisat("What is the highest binary number that can be referred to on a three position jumper block?","4","6","5","1","1","E");
        this.addQuestionIktisat(q65);
        QuestionIktisat q66 = new QuestionIktisat("During boot-up, the memory test:","Is a superfluous step that should be ignored","Checks and verifies that contiguous memory is installed","Is an operational error","Displays what memory is installed, but nothing else","Checks and verifies that contiguous memory is installed","E");
        this.addQuestionIktisat(q66);
        QuestionIktisat q67 = new QuestionIktisat("IRQ6 is typically reserved for:","The floppy","The keyboard controller","LPT2","The modem","The floppy","E");
        this.addQuestionIktisat(q67);
        QuestionIktisat q68 = new QuestionIktisat("Which would you do first when troubleshooting a faulty monitor?","Check its connections to the computer and power source","Use a meter to check the CRT and internal circuitry for continuity","Power down the monitor, then turn it on again to see if that corrects the problem","Power down the computer, then turn it on again to see if that corrects the problem","Check its connections to the computer and power source","E");
        this.addQuestionIktisat(q68);
        QuestionIktisat q69 = new QuestionIktisat("To install a second IDE drive into a computer, you must:","Set the master-slave jumper to slave on the second drive","Use the IDE configuration software to set the new drive as slave","Verify that you define the new drive as D: in the CMOS setup","Verify that you attach the drive to the connector at the end of the ribbon cable","Set the master-slave jumper to slave on the second drive","E");
        this.addQuestionIktisat(q69);
        QuestionIktisat q70 = new QuestionIktisat("Why does a successfully mapped network drive disappear every time you boot the computer?","The computer you are connected to has moved","You didn't click reconnect on log on","The map statement is not in the autoexec.bat file","The last drive was not set correctly","The map statement is not in the autoexec.bat file","E");
        this.addQuestionIktisat(q70);
        QuestionIktisat q71 = new QuestionIktisat("What do you need to check serial and parallel port?","Port adapter","Logic probe","Loopback plug","All of the above","Loopback plug","E");
        this.addQuestionIktisat(q71);
        QuestionIktisat q72 = new QuestionIktisat("You have a PC with no video* Which of the following is LEAST likely to be causing the problem?","defective RAM (bank zero)","defective microprocessor","crashed hard drive","loose video card","crashed hard drive","E");
        this.addQuestionIktisat(q72);
        QuestionIktisat q73 = new QuestionIktisat("To test for AC ripple on a PC power supply, you would set the volt/ohm meter for:","DC voltage scale","AC voltage","OHM scale","Farad scale","AC voltage","E");
        this.addQuestionIktisat(q73);
        QuestionIktisat q74 = new QuestionIktisat("You get a CMOS checksum error during bootup. What is most likely the cause?","power supply is bad","BIOS needs updating","CMOS battery is nearing end of life","hard drive types are incorrectly defined","CMOS battery is nearing end of life","E");
        this.addQuestionIktisat(q74);
        QuestionIktisat q75 = new QuestionIktisat("On the 16-bit ISA bus, IRQ2 is elevated to which higher level interrupt?","9","11","13","15","9","E");
        this.addQuestionIktisat(q75);
        QuestionIktisat q76 = new QuestionIktisat("After trying to unload a TSR, you get an error message saying that other TSRs were loaded after the one you tried to remove. Which of the following commands could you use to see the current load order?","MEM /P","MEMMAKER","MEM /C","SYS:","SYS:","E");
        this.addQuestionIktisat(q76);
        QuestionIktisat q77 = new QuestionIktisat("What is a common language that computers use to talk with one another on a network","client","adapter","protocol","operating systems","protocol","E");
        this.addQuestionIktisat(q77);
        QuestionIktisat q78 = new QuestionIktisat("Which DOS driver is used to emulate expanded memory?","Himem.sys","EMM386.exe","Mem386.sys","Ramdrive.sys","EMM386.exe","E");
        this.addQuestionIktisat(q78);
        QuestionIktisat q79 = new QuestionIktisat("Which should you use for cleaning Mylar-protected LCD screens?","Ammonia window cleaner","Non-abrasive cleanser","Anti-static wipes","Alcohol-impregnated wipes","Non-abrasive cleanser","E");
        this.addQuestionIktisat(q79);
        QuestionIktisat q80 = new QuestionIktisat("What could cause a fixed disk error?","No-CD installed","Bad RAM","Slow processor","Incorrect CMOS settings","Incorrect CMOS settings","E");
        this.addQuestionIktisat(q80);
        QuestionIktisat q81 = new QuestionIktisat("ESD potential decreases with the use of:","De-ionizing fans","A wrist strap","Rubber gloves with matching cap","A static meter","A wrist strap","E");
        this.addQuestionIktisat(q81);
        QuestionIktisat q82 = new QuestionIktisat("Which of the following FRUs would be considered both an input/output device?","Video board","SCSI host adapter","System board CPU","All of the above","SCSI host adapter","E");
        this.addQuestionIktisat(q82);
        QuestionIktisat q83 = new QuestionIktisat("A COM port is a _____ port.","parallel","serial","static","multi","serial","E");
        this.addQuestionIktisat(q83);
        QuestionIktisat q84 = new QuestionIktisat("Which device is on IRQ 6?","Keyboard","IDE","Floppy drive","Video card","Floppy drive","E");
        this.addQuestionIktisat(q84);
        QuestionIktisat q85 = new QuestionIktisat("A system has two IDE hard drives that are each divided into primary and extended partitions, which drive letter is assigned to the primary partition of the second drive?","C","D","E","F","D","E");
        this.addQuestionIktisat(q85);
        QuestionIktisat q86 = new QuestionIktisat("What is the most significant difference between the USB and IEEE1394 standards?","IEEE 1394 is faster","USB does not support USB","USB is plug and play","IEEE 1394 is hot swappable","IEEE 1394 is faster","E");
        this.addQuestionIktisat(q86);
        QuestionIktisat q87 = new QuestionIktisat("When connecting two internal SCSI hard disks to a computer, where do you connect the second hard drive?","Any open SCSI port on the computer","A Serial port on the first host adapter","An open parallel port on the computer","An open SCSI port on the first hard drive","Any open SCSI port on the computer","E");
        this.addQuestionIktisat(q87);
        QuestionIktisat q88 = new QuestionIktisat("When connecting a ribbon cable to a connector, how do you know which direction to plug it in?","The red line in the cable goes to the highest pin number","The colored line in the cable goes to pin #1","It does not matter","The blue or red line in the cable goes away from the power connector","The colored line in the cable goes to pin #1","E");
        this.addQuestionIktisat(q88);
        QuestionIktisat q89 = new QuestionIktisat("What is the first step in diagnosing a completely dead computer at the client site that was working the day before.","Test the power supply","replace the CMOS battery","check the AC outlet","reseat the hard drive controller cable","check the AC outlet","E");
        this.addQuestionIktisat(q89);
        QuestionIktisat q90 = new QuestionIktisat("What specification covers PC hard cards?","SCSI","ISA"," PCMCIA","MFM","PCMCIA","E");
        this.addQuestionIktisat(q90);
        QuestionIktisat q91 = new QuestionIktisat("Which common bus specification provides the fastest data transfer rate?","VL bus","ISA","PCI","All of the above","PCI","E");
        this.addQuestionIktisat(q91);
        QuestionIktisat q92 = new QuestionIktisat("Modems use transmission.","synchronous","asynchronous","timed interval","ata","asynchronous","E");
        this.addQuestionIktisat(q92);
        QuestionIktisat q93 = new QuestionIktisat("A 6xx indicates a problem with the:","floppy drive","hard drive","keyboard","CD ROM","floppy drive","E");
        this.addQuestionIktisat(q93);
        QuestionIktisat q94 = new QuestionIktisat("A sound card typically uses which IRQ?","6","5","15","1","5","E");
        this.addQuestionIktisat(q94);
        QuestionIktisat q95 = new QuestionIktisat("During preventative maintenance on a dot matrix printer, do NOT lubricate:","Platen assembly","Print head pulley","Print head pins","Paper advance gear bushings","Print head pins","E");
        this.addQuestionIktisat(q95);
        QuestionIktisat q96 = new QuestionIktisat("You see the message \"invalid media device\" after installing a new hard drive. What do you do next?","Format","Fdisk","Partition","Add the OS","Format","E");
        this.addQuestionIktisat(q96);
        QuestionIktisat q97 = new QuestionIktisat("What is the modem hang up command?","ATHU","ATH","ATZ","ATX","ATH","E");
        this.addQuestionIktisat(q97);
        QuestionIktisat q98 = new QuestionIktisat("What expansion types do most pll/plll motherboards support?","MCA, PCI","ISA, EISA","ISA, PCI, AGP","ISA, VESA, PCI","ISA, PCI, AGP","E");
        this.addQuestionIktisat(q98);
        QuestionIktisat q99 = new QuestionIktisat("When installing an internal modem, all of the following IRQ's can be used except?","5","10","14","All of the above","14","E");
        this.addQuestionIktisat(q99);
        QuestionIktisat q100 = new QuestionIktisat("An IRQ allow interface cards to:","Interrupt the CPU to request service","Pass data to the CPU to be processed","Pass data from one card to another","Pass data to the computers memory","Interrupt the CPU to request service","E");
        this.addQuestionIktisat(q100);
        QuestionIktisat q101 =  new QuestionIktisat("What is the default IRQ for LPT1?","2","5","7","13","7","I");
        this.addQuestionIktisat(q101);
        QuestionIktisat q102= new QuestionIktisat("What is the most probable cause of a sound card and a printer working intermittently?","Conflicting IRQs.","The wrong APM setting.","A changed printer cable.","An improperly seated card.","Conflicting IRQs.","I");
        this.addQuestionIktisat(q102);
        QuestionIktisat q103= new QuestionIktisat("USB can supply power for all of the following except ","4 port hub","Keyboard","Mouse","External hard drive","4 port hub","I");
        this.addQuestionIktisat(q103);
        QuestionIktisat q104= new QuestionIktisat("What is the default IRQ for COM1?","2","3","4","5","4","I");
        this.addQuestionIktisat(q104);
        QuestionIktisat q105= new QuestionIktisat("When configuring ISA network interface cards without jumpers or plug and play. What is used to set IRQs?","DMA.","COMS.","The operating system","Configuration software","Configuration software","I");
        this.addQuestionIktisat(q105);
        QuestionIktisat q106= new QuestionIktisat("What is the default IRQ for the floppy drive controller?","2","3","6","9","6","I");
        this.addQuestionIktisat(q106);
        QuestionIktisat q107= new QuestionIktisat("Which interrupt is reserved for the system timer?","0","1","8","13","0","I");
        this.addQuestionIktisat(q107);
        QuestionIktisat q108= new QuestionIktisat("When connecting to an 802.11 Wireless access point, which mode should be used?","WEP","Infrastructure","Ad-hoc","Remote","WEP","I");
        this.addQuestionIktisat(q108);
        QuestionIktisat q109= new QuestionIktisat("What do you need to do when replacing the motherboard in a portable computer?","Ensure that the board is AT or ATX."," Match the manufacturer and the model number exactly.","Any motherboard will act as long as it is specified for a laptop.","Ensure that the board is from that manufacturer and that the boards are interchangeable.","Ensure that the board is from that manufacturer and that the boards are interchangeable.","I");
        this.addQuestionIktisat(q109);
        QuestionIktisat q110= new QuestionIktisat("You have installed a new modem with jumpers set to COM2 and IRQ3, but Windows cannot detect the modem. What is the problem?","No dial tone","IRQ conflict","DMA overrun","COM port speed not set to 256Kbps","IRQ conflict","I");
        this.addQuestionIktisat(q110);
        QuestionIktisat q111= new QuestionIktisat("Which interrupt does the real-time clock use?","0","1","8","13","8","I");
        this.addQuestionIktisat(q111);
        QuestionIktisat q112= new QuestionIktisat("What is the smallest space to store data on a hard drive?","Track","Sector","Cluster","Cylinder","Sector","I");
        this.addQuestionIktisat(q112);
        QuestionIktisat q113= new QuestionIktisat("What is the maximum cable length, in meters, using 20-gauge twisted-pair shielded cable between two full speed USB devices?","5","6","7","8","5","I");
        this.addQuestionIktisat(q113);
        QuestionIktisat q114= new QuestionIktisat("Which setting must a device have in order to interrupt the CPU?","IRQ","I/O address","DMA channel","Memory address","IRQ","I");
        this.addQuestionIktisat(q114);
        QuestionIktisat q115= new QuestionIktisat("What the maximum length for a cable connection of a full speed USB device to a PC is. What will your reply be?","3 M","4 M","5 M","6 M","5 M","I");
        this.addQuestionIktisat(q115);
        QuestionIktisat q116= new QuestionIktisat("The electrical connector between the docking station and a portable computer is","Used as a surge suppressor","Manufacturer specific only"," Manufacturer and model specific","Not propriety but is an industry standard","Manufacturer specific only","I");
        this.addQuestionIktisat(q116);
        QuestionIktisat q117= new QuestionIktisat("A technician connects a joystick to a sound card. What IRQ would the joystick use?","IRQ 2","IRQ 5","IRQ 10","Joystick does not use an IRQ","IRQ 5","I");
        this.addQuestionIktisat(q117);
        QuestionIktisat q118= new QuestionIktisat("RJ-45 connectors are used in which of the following topologies?","10Base2","10Base5","10BaseT","10BaseFL","10Base2","I");
        this.addQuestionIktisat(q118);
        QuestionIktisat q119= new QuestionIktisat("From what location are the 1st computer instructions available on boot up?","ROM BIOS","CPU","boot.ini","config.sys","ROM BIOS","I");
        this.addQuestionIktisat(q119);
        QuestionIktisat q120= new QuestionIktisat("What could cause a fixed disk error.","No CD installed","Bad RAM","Slow Processor","Incorrect cmos settings","Incorrect cmos settings","I");
        this.addQuestionIktisat(q120);
        QuestionIktisat q121= new QuestionIktisat("Missing slot covers on a computer can cause?","over heat","power surge","EMI","high voltage","over heat","I");
        this.addQuestionIktisat(q121);
        QuestionIktisat q122= new QuestionIktisat("With respect to a network interface card, the term 10/100 refers to","protocol speed","a fiber speed","megabits per seconds","maximum server speed","megabits per seconds","I");
        this.addQuestionIktisat(q122);
        QuestionIktisat q123= new QuestionIktisat("Which Motherboard form factor uses one 20 pin connector","ATX","AT","BABY AT","BIG AT","ATX","I");
        this.addQuestionIktisat(q123);
        QuestionIktisat q124= new QuestionIktisat("A hard disk is divided into tracks which are further subdivided into","clusters","sectors","cylinder","bits","sectors","I");
        this.addQuestionIktisat(q124);
        QuestionIktisat q125 = new QuestionIktisat("From what location are the 1st computer instructions available on boot up?","ROM BIOS","CPU","boot.ini","CONFIG.SYS","ROM BIOS","I");
        this.addQuestionIktisat(q125);
        QuestionIktisat q126 = new QuestionIktisat("What could cause a fixed disk error.","No-CD installed","bad ram","slow processor","Incorrect CMOS settings","Incorrect CMOS settings","I");
        this.addQuestionIktisat(q126);
        QuestionIktisat q127 = new QuestionIktisat("Missing slot covers on a computer can cause?","over heat","power surges","EMI","incomplete path for ESD","over heat","I");
        this.addQuestionIktisat(q127);
        QuestionIktisat q128 = new QuestionIktisat("When installing PCI NICS you can check the IRQ availability by looking at","dip switches","CONFIG.SYS","jumper settings","motherboard BIOS","motherboard BIOS","I");
        this.addQuestionIktisat(q128);
        QuestionIktisat q129 = new QuestionIktisat("With respect to a network interface card, the term 10/100 refers to","protocol speed","a fiber speed","megabits per seconds","minimum and maximum server speed","megabits per seconds","I");
        this.addQuestionIktisat(q129);
        QuestionIktisat q130 = new QuestionIktisat("ESD potential decreases with the use of:","De-ionizing fans","A wrist strap","Rubber gloves with matching cap","A static meter","A wrist strap","I");
        this.addQuestionIktisat(q130);
        QuestionIktisat q131 = new QuestionIktisat("Which of the following FRUs would be considered both an input/output device?","Video board","SCSI host adapter","System board CPU","All of the above","SCSI host adapter","I");
        this.addQuestionIktisat(q131);
        QuestionIktisat q132 = new QuestionIktisat("A COM port is a _____ port.","parallel","serial","static","multi","serial","I");
        this.addQuestionIktisat(q132);
        QuestionIktisat q133 = new QuestionIktisat("Which device is on IRQ 6?","Keyboard","IDE","Floppy drive","Video card","Floppy drive","I");
        this.addQuestionIktisat(q133);
        QuestionIktisat q134 = new QuestionIktisat("A system has two IDE hard drives that are each divided into primary and extended partitions, which drive letter is assigned to the primary partition of the second drive?","C","D","E","F","D","I");
        this.addQuestionIktisat(q134);
        QuestionIktisat q135= new QuestionIktisat("A wrist grounding strap contains which of the following:","surge protector","capacitor","voltmeter","resistor","resistor","I");
        this.addQuestionIktisat(q135);
        QuestionIktisat q136= new QuestionIktisat("Which standard govern parallel communications?","RS232","RS232-a","CAT 5","IEEE 1284","IEEE 1284","I");
        this.addQuestionIktisat(q136);
        QuestionIktisat q137= new QuestionIktisat("What product is used to clean smudged keys on a keyboard?","TMC solvent","Silicone spray","Denatured alcohol","All-purpose cleaner","All-purpose cleaner","I");
        this.addQuestionIktisat(q137);
        QuestionIktisat q138= new QuestionIktisat("ESD would cause the most damage to which component?","Power supply","Expansion board","Monitor","Keyboard","Expansion board","I");
        this.addQuestionIktisat(q138);
        QuestionIktisat q139= new QuestionIktisat("Which peripheral port provides the FASTEST throughput to laser printers?","RS-232","SCSI","Parallel","Serial","Parallel","I");
        this.addQuestionIktisat(q139);
        QuestionIktisat q140= new QuestionIktisat("The mouse pointer moves erratically, what is the possible cause? The mouse","ball is dirty","is not connected","driver is not installed properly","has an incorrect IRQ setting","ball is dirty","I");
        this.addQuestionIktisat(q140);
        QuestionIktisat q141= new QuestionIktisat("Voltage4s measured:","in parallel","in series","after breaking the circuit","after checking resistance","in parallel","I");
        this.addQuestionIktisat(q141);
        QuestionIktisat q142= new QuestionIktisat("What is the highest binary number that can be referred to on a three position jumper block?","4","6","F","1","1","I");
        this.addQuestionIktisat(q142);
        QuestionIktisat q143= new QuestionIktisat("During boot-up, the memory test:","Is a superfluous step that should be ignored","Checks and verifies that contiguous memory is installed","Is an operational error","Displays what memory is installed, but nothing else","Checks and verifies that contiguous memory is installed","I");
        this.addQuestionIktisat(q143);
        QuestionIktisat q144= new QuestionIktisat("What do you need to check serial and parallel port?","Port adapter","Logic probe","Loopback plug","All of the above","Loopback plug","I");
        this.addQuestionIktisat(q144);
        QuestionIktisat q145= new QuestionIktisat("To test for AC ripple on a PC power supply, you would set the volt/ohm meter for:","DC","AC","Ohm","Farad","AC","I");
        this.addQuestionIktisat(q145);
        QuestionIktisat q146= new QuestionIktisat("On the 16-bit ISA bus, IRQ2 is elevated to which higher level interrupt?","9","11","13","15","9","I");
        this.addQuestionIktisat(q146);
        QuestionIktisat q147= new QuestionIktisat("What is a common language that computers use to talk with one another on a network","client","adapter","protocol","OS","protocol","I");
        this.addQuestionIktisat(q147);
        QuestionIktisat q148= new QuestionIktisat("A COM port is a _____ port.","parallel","serial","static","multi","serial","I");
        this.addQuestionIktisat(q148);
        QuestionIktisat q149= new QuestionIktisat("Modems use transmission.","synchronous","asynchronous","timed interval","ata","asynchronous","I");
        this.addQuestionIktisat(q149);
        QuestionIktisat q150= new QuestionIktisat("The DC voltage on most circuit boards is:","-12 V","0 V","+5 V","+12 V","+5 V","I");
        this.addQuestionIktisat(q150);
        }

public void addQuestionIktisat(QuestionIktisat quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION2());
        values.put(KEY_ANSWER, quest.getANSWER2());
        values.put(KEY_OPTA, quest.getOPTA2());
        values.put(KEY_OPTB, quest.getOPTB2());
        values.put(KEY_OPTC, quest.getOPTC2());
        values.put(KEY_OPTD, quest.getOPTD2());
        values.put(KEY_CAT,quest.getCATEGORY2());
        // Inserting Row
        dbase.insert(TABLE_QUEST2, null, values);
        }

private void addQuestionsMuhendislik() {
        QuestionMuhendislik q1 = new QuestionMuhendislik("Which backup method is quickest and requires the least amount of backup storage space ?","Daily","Normal","Differential","Incremental","Incremental","B");
        this.addQuestionMuhendislik(q1);
        QuestionMuhendislik q2 = new QuestionMuhendislik("Scan disk checks and fixes ____.","Tape drives","Hard drives","CD-ROM drives","DVD-ROM drives","Hard drives","B");
        this.addQuestionMuhendislik(q2);
        QuestionMuhendislik q3 = new QuestionMuhendislik("Where is the DIR command located ?","C:|WINDOWS","COMMAND.COM","C:|WINDOWS|SYSTEM","C:|WINDOWS|COMMAND","COMMAND.COM","B");
        this.addQuestionMuhendislik(q3);
        QuestionMuhendislik q4 = new QuestionMuhendislik("Which command allows you to view or edit configuration files ?","SYSEDIT","REGEDIT","CFGEDIT","AUTOEDIT","SYSEDIT","B");
        this.addQuestionMuhendislik(q4);
        QuestionMuhendislik q5 = new QuestionMuhendislik("Which utility is the best for editing Windows 95 registry ?","Edit","Regedit","Reged32","Device Manager","Regedit","B");
        this.addQuestionMuhendislik(q5);
        QuestionMuhendislik q6 = new QuestionMuhendislik("Which files determines the multiboot configuration of Windows 9x ?","IO.SYS","SYSTEM.INI","MSDOS.SYS","CONFIG.SYS","MSDOS.SYS","B");
        this.addQuestionMuhendislik(q6);
        QuestionMuhendislik q7 = new QuestionMuhendislik("Which key strokes switch a user between simultaneously running applications in windows ?","FN+TAB","ALT+TAB","CTRL+TAB","SHIFT+TAB","ALT+TAB","B");
        this.addQuestionMuhendislik(q7);
        QuestionMuhendislik q8 = new QuestionMuhendislik("WHat type of file is the Windows 9x registry ?","Flat text file","Relational database","Hierarchical databse","Spread sheet template","Hierarchical databse","B");
        this.addQuestionMuhendislik(q8);
        QuestionMuhendislik q9 = new QuestionMuhendislik("Wich of these statements would be found in the autoexec.bat file ?","FILES=40","PATH=C:\\;","DOS=HIGH,UMB","DEVICE=HIMEM.SYS","PATH=C:\\;","B");
        this.addQuestionMuhendislik(q9);
        QuestionMuhendislik q10 = new QuestionMuhendislik("What is the proper command to install the Windows 2000 Recovery Console as a start up option if the CD Rom is Drive E ?","E:|i386\\SETUP.EXE\\CONSOLE","E:|i386\\CONSOLE.EXE\\INSTALL","E:|i386\\WINNT32.EXE\\CMDCONS","E:|i386\\WIN2000.EXE\\RECOVERY","E:|i386\\WINNT32.EXE\\CMDCONS","B");
        this.addQuestionMuhendislik(q10);
        QuestionMuhendislik q11 = new QuestionMuhendislik("The part of machine level instruction, which tells the central processor what has to be done, is","Operation code","Address","Locator","Flip-Flop","Operation code","B");
        this.addQuestionMuhendislik(q11);
        QuestionMuhendislik q12 = new QuestionMuhendislik("Which of the following refers to the associative memory?","the address of the data is generated by the CPU","the address of the data is supplied by the users","there is no need for an address i.e. the data is used as an address","the data are accessed sequentially","there is no need for an address i.e. the data is used as an address","B");
        this.addQuestionMuhendislik(q12);
        QuestionMuhendislik q13 = new QuestionMuhendislik("To avoid the race condition, the number of processes that may be simultaneously inside their critical section is","8","16","1","0","1","B");
        this.addQuestionMuhendislik(q13);
        QuestionMuhendislik q14 = new QuestionMuhendislik("A system program that combines the separately compiled modules of a program into a form suitable for execution","assembler","assembler","cross compiler","load and go","linking loader","B");
        this.addQuestionMuhendislik(q14);
        QuestionMuhendislik q15 = new QuestionMuhendislik("Process is","program in High level language kept on disk","contents of main memory","a program in execution","a job in secondary memory","a program in execution","B");
        this.addQuestionMuhendislik(q15);
        QuestionMuhendislik q16 = new QuestionMuhendislik("Addressing structure","defines the fundamental method of determining effective operand addresses","are variations in the use of fundamental addressing structures, or some associated actions which are related to addressing","performs indicated operations on two fast registers of the machine and leave the result in one of the registers","all of the above","defines the fundamental method of determining effective operand addresses","B");
        this.addQuestionMuhendislik(q16);
        QuestionMuhendislik q17 = new QuestionMuhendislik("all of the above","is a hardware memory device which denotes the location of the current instruction being executed","is a group of electrical circuits (hardware), that performs the intent of instructions fetched from memory","contains the address of the memory location that is to be read from or stored into","contains a copy of the designated memory location specified by the MAR after a \"read\" or the new contents of the memory prior to a \"write\"","contains a copy of the designated memory location specified by the MAR after a \"read\" or the new contents of the memory prior to a \"write\"","B");
        this.addQuestionMuhendislik(q17);
        QuestionMuhendislik q18 = new QuestionMuhendislik("The strategy of allowing processes that are logically runnable to be temporarily suspended is called","preemptive scheduling","non preemptive scheduling","shortest job first","shortest job first","preemptive scheduling","B");
        this.addQuestionMuhendislik(q18);
        QuestionMuhendislik q19 = new QuestionMuhendislik("The LRU algorithm","pages out pages that have been used recently","pages out pages that have not been used recently","pages out pages that have been least used recently","pages out the first page in a given area","pages out pages that have been least used recently","B");
        this.addQuestionMuhendislik(q19);
        QuestionMuhendislik q20 = new QuestionMuhendislik("Which of the following systems software does the job of merging the records from two files into one?","Security software","Utility program","Networking software","Documentation system","Utility program","B");
        this.addQuestionMuhendislik(q20);
        QuestionMuhendislik q21 = new QuestionMuhendislik("Fork is","the dispatching of a task","the creation of a new job","the creation of a new process","increasing the priority of a task","the creation of a new process","B");
        this.addQuestionMuhendislik(q21);
        QuestionMuhendislik q22 = new QuestionMuhendislik("Thrashing","is a natural consequence of virtual memory systems","can always be avoided by swapping","always occurs on large computers","can be caused by poor paging algorithms","can be caused by poor paging algorithms","B");
        this.addQuestionMuhendislik(q22);
        QuestionMuhendislik q23 = new QuestionMuhendislik("Supervisor state is","never used","entered by programs when they enter the processor","required to perform any I/O","only allowed to the operating system","only allowed to the operating system","B");
        this.addQuestionMuhendislik(q23);
        QuestionMuhendislik q24 = new QuestionMuhendislik("Which of the following instruction steps, would be written within the diamond-shaped box, of a flowchart?","S = B - C","IS A<10","PRINT A","DATA X,4Z","IS A<10","B");
        this.addQuestionMuhendislik(q24);
        QuestionMuhendislik q25 = new QuestionMuhendislik("Which of the following statements is false?","the technique of storage compaction involves moving all occupied areas of storage to one end or other of main storage","compaction does not involve relocation of programs","compaction is also know as garbage collection","the system must stop everything while it performs the compaction","compaction does not involve relocation of programs","B");
        this.addQuestionMuhendislik(q25);
        QuestionMuhendislik q26 = new QuestionMuhendislik("Interprocess communication","is required for all processes","is usually done via disk drives","is never necessary","allows processes to synchronize activity","allows processes to synchronize activity","B");
        this.addQuestionMuhendislik(q26);
        QuestionMuhendislik q27 = new QuestionMuhendislik("Which of the following functions is(are) performed by the loader","allocate space in memory for the programs and resolve symbolic references between object decks","adjust all address dependent locations, such as address constants, to correspond to the allocated space","physically place the machine instructions and data into memory","All of the above","All of the above","B");
        this.addQuestionMuhendislik(q27);
        QuestionMuhendislik q28 = new QuestionMuhendislik("User-Friendly Systems are:","required for object-oriented programming","easy to develop","common among traditional mainframe operating systems","becoming more common","becoming more common","B");
        this.addQuestionMuhendislik(q28);
        QuestionMuhendislik q29 = new QuestionMuhendislik("Which of the following addressing modes, facilitates access to an operand whose location is defined relative to the beginning of the data structure in which it appears?","ascending","sorting","index","indirect","index","B");
        this.addQuestionMuhendislik(q29);
        QuestionMuhendislik q30 = new QuestionMuhendislik("While running DOS on a PC, which command would be used to duplicate the entire diskette?","COPY","DISKCOPY","CHKDSK","TYPE","DISKCOPY","B");
        this.addQuestionMuhendislik(q30);
        QuestionMuhendislik q31 = new QuestionMuhendislik("Memory","is a device that performs a sequence of operations specified by instructions in memory.","is the device where information is stored","is a sequence of instructions","is typically characterized by interactive processing and time-slicing of the CPU's time to allow quick response to each user.","is the device where information is stored","B");
        this.addQuestionMuhendislik(q31);
        QuestionMuhendislik q32 = new QuestionMuhendislik("Which of the following rules out the use of GO TO?","Flowchart","HIPO-DIAGRAMS","Nassi-Shneiderman diagram","All of the above","Nassi-Shneiderman diagram","B");
        this.addQuestionMuhendislik(q32);
        QuestionMuhendislik q33 = new QuestionMuhendislik("A system program that sets up an executable program in main memory ready for execution is","assembler","linker","loader","compiler","loader","B");
        this.addQuestionMuhendislik(q33);
        QuestionMuhendislik q34 = new QuestionMuhendislik("A system program that sets up an executable program in main memory ready for execution is","assembler","linker","loader","compiler","loader","B");
        this.addQuestionMuhendislik(q34);
        QuestionMuhendislik q35 = new QuestionMuhendislik("Which of the following are loaded into main memory when the computer is booted?","internal command instructions","external command instructions","utility programs","word processing instructions","internal command instructions","B");
        this.addQuestionMuhendislik(q35);
        QuestionMuhendislik q36 = new QuestionMuhendislik("The FIFO algorithm","executes first the job that last entered the queue","executes first the job that first entered the queue","execute first the job that has been in the queue the longest","executes first the job with the least processor needs","executes first the job that first entered the queue","B");
        this.addQuestionMuhendislik(q36);
        QuestionMuhendislik q37 = new QuestionMuhendislik("What is the name given to the organized collection of software that controls the overall operation of a computer?","Working system","Peripheral system","Operating system","Controlling system","Operating system","B");
        this.addQuestionMuhendislik(q37);
        QuestionMuhendislik q38 = new QuestionMuhendislik("The principle of locality of reference justifies the use of","reenterable","non reusable","virtual memory","cache memory","cache memory","B");
        this.addQuestionMuhendislik(q38);
        QuestionMuhendislik q39 = new QuestionMuhendislik("The register or main memory location which contains the effective address of the operand is known as","pointer","indexed register","special location","scratch pad","pointer","B");
        this.addQuestionMuhendislik(q39);
        QuestionMuhendislik q40 = new QuestionMuhendislik("Assembly code data base is associated with","assembly language version of the program which is created by the code generation phase and is input to the assembly phase.","a permanent table of decision rules in the form of patterns for matching with the uniform symbol table to discover syntactic structure.","consists of a full or partial list or the token's as they appear in the program. Created by Lexical analysis and used for syntax analysis and interpretation.","a permanent table which lists all key words and special symbols of the language in symbolic form.","assembly language version of the program which is created by the code generation phase and is input to the assembly phase.","B");
        this.addQuestionMuhendislik(q40);
        QuestionMuhendislik q41 = new QuestionMuhendislik("Thrashing can be avoided if","the pages, belonging to the working set of the programs, are in main memory","the speed of CPU is increased","the speed of I/O processor is increased","all of the above","the pages, belonging to the working set of the programs, are in main memory","B");
        this.addQuestionMuhendislik(q41);
        QuestionMuhendislik q42 = new QuestionMuhendislik("In analyzing the compilation of PL/I program, the term \"Lexical analysis\" is associated with","recognition of basic syntactic constructs through reductions.","recognition of basic elements and creation of uniform symbols","creation of more optional matrix.","use of macro processor to produce more optimal assembly code","recognition of basic elements and creation of uniform symbols","B");
        this.addQuestionMuhendislik(q42);
        QuestionMuhendislik q43 = new QuestionMuhendislik("Resolution of externally defined symbols is performed by","Linker","Loader","Compiler","Assembler","Linker","B");
        this.addQuestionMuhendislik(q43);
        QuestionMuhendislik q44 = new QuestionMuhendislik("System generation:","is always quite simple","is always very difficult","varies in difficulty between systems","requires extensive tools to be understandable","varies in difficulty between systems","B");
        this.addQuestionMuhendislik(q44);
        QuestionMuhendislik q45 = new QuestionMuhendislik("The Memory Address Register","is a hardware memory device which denotes the location of the current instruction being executed.","is a group of electrical circuits (hardware), that performs the intent of instructions fetched from memory.","contains the address of the memory location that is to be read from or stored into.","contains a copy of the designated memory location specified by the MAR after a \"read\" or the new contents of the memory prior to a \"write\".","contains the address of the memory location that is to be read from or stored into.","B");
        this.addQuestionMuhendislik(q45);
        QuestionMuhendislik q46 = new QuestionMuhendislik("In virtual memory systems, Dynamic address translation","is the hardware necessary to implement paging","stores pages at a specific location on disk","is useless when swapping is used","is part of the operating system paging algorithm","is the hardware necessary to implement paging","B");
        this.addQuestionMuhendislik(q46);
        QuestionMuhendislik q47 = new QuestionMuhendislik("Fragmentation of the file system","occurs only if the file system is used improperly","can always be prevented","can be temporarily removed by compaction","is a characteristic of all file systems","can be temporarily removed by compaction","B");
        this.addQuestionMuhendislik(q47);
        QuestionMuhendislik q48 = new QuestionMuhendislik("A non-relocatable program is one which","cannot be made to execute in any area of storage other than the one designated for it at the time of its coding or translation.","consists of a program and relevant information for its relocation.","can itself performs the relocation of its address-sensitive portions.","all of the above","cannot be made to execute in any area of storage other than the one designated for it at the time of its coding or translation.","B");
        this.addQuestionMuhendislik(q48);
        QuestionMuhendislik q49 = new QuestionMuhendislik("Which of the following are(is) Language Processor(s)","assembles","compilers","interpreters","All of the above","All of the above","B");
        this.addQuestionMuhendislik(q49);
        QuestionMuhendislik q50 = new QuestionMuhendislik("In which addressing mode the effective address of the operand is the contents of a register specified in the instruction and after accessing the operand, the contents of this register is incremented to point to the next item in the list?","index addressing","indirect addressing","auto increment","auto decrement","auto increment","B");
        this.addQuestionMuhendislik(q50);
        QuestionMuhendislik q51 = new QuestionMuhendislik("The memory allocation scheme subject to \"external\" fragmentation is","segmentation","swapping","pure demand paging","multiple contiguous fixed partitions","segmentation","I");
        this.addQuestionMuhendislik(q51);
        QuestionMuhendislik q52 = new QuestionMuhendislik("While working with MS-DOS, which command will you use to transfer a specific file from one disk to another?","DISKCOPY","COPY","RENAME","FORMAT","COPY","I");
        this.addQuestionMuhendislik(q52);
        QuestionMuhendislik q53 = new QuestionMuhendislik("What is the name of the operating system for the laptop computer called MacLite?","Windows","DOS","MS-DOS","OZ","OZ","I");
        this.addQuestionMuhendislik(q53);
        QuestionMuhendislik q54 = new QuestionMuhendislik("In which addressing mode the contents of a register specified in the instruction are first decremented, and then these contents are used as the effective address of the operands?","index addressing","indirect addressing","auto increment","auto decrement","auto decrement","I");
        this.addQuestionMuhendislik(q54);
        QuestionMuhendislik q55 = new QuestionMuhendislik("What is the name given to the values that are automatically provided by software to reduce keystrokes and improve a computer user's productivity?","Defined values","Fixed values","Default values","Special values","Default values","I");
        this.addQuestionMuhendislik(q55);
        QuestionMuhendislik q56 = new QuestionMuhendislik("Page stealing","is a sign of an efficient system","is taking page frames from other working sets","should be the tuning goal","is taking larger disk spaces for pages paged out","is taking page frames from other working sets","I");
        this.addQuestionMuhendislik(q56);
        QuestionMuhendislik q57 = new QuestionMuhendislik("In MS-DOS 5.0, which is the number that acts as a code to uniquely identify the software product?","MS","DOS","MS DOS","5.0","5.0","I");
        this.addQuestionMuhendislik(q57);
        QuestionMuhendislik q58 = new QuestionMuhendislik("Bug means","A logical error in a program","A difficult syntax error in a program","Documenting programs using an efficient documentation tool","All of the above","A logical error in a program","I");
        this.addQuestionMuhendislik(q58);
        QuestionMuhendislik q59 = new QuestionMuhendislik("Memory management is :","not used in modern operating system","replaced with virtual memory on current systems","not used on multiprogramming systems","critical for even the simplest operating systems","critical for even the simplest operating systems","I");
        this.addQuestionMuhendislik(q59);
        QuestionMuhendislik q60 = new QuestionMuhendislik("The initial value of the semaphore that allows only one of the many processes to enter their critical sections, is","8","1","16","0","1","I");
        this.addQuestionMuhendislik(q60);
        QuestionMuhendislik q61 = new QuestionMuhendislik("The Register - to - Register (RR) instructions","have both their operands in the main store.","which perform an operation on a register operand and an operand which is located in the main store, generally leaving the result in the register, except in the case of store operation when it is also written into the specified storage location.","which perform indicated operations on two fast registers of the machine and leave the result in one of the registers.","all of the above","which perform indicated operations on two fast registers of the machine and leave the result in one of the registers.","I");
        this.addQuestionMuhendislik(q61);
        QuestionMuhendislik q62 = new QuestionMuhendislik("A page fault","is an error is a specific page","occurs when a program accesses a page of memory","is an access to a page not currently in memory","is a reference to a page belonging to another program","is an access to a page not currently in memory","I");
        this.addQuestionMuhendislik(q62);
        QuestionMuhendislik q63 = new QuestionMuhendislik("An algorithm is best described as","A computer langage","A step by step procedure for solving a problem","A branch of mathematics","All of the above","A step by step procedure for solving a problem","I");
        this.addQuestionMuhendislik(q63);
        QuestionMuhendislik q64 = new QuestionMuhendislik("The process of transferring data intended for a peripheral device into a disk (or intermediate store) so that it can be transferred to peripheral at a more convenient time or in bulk, is known as","multiprogramming","spooling","caching","virtual programming","spooling","I");
        this.addQuestionMuhendislik(q64);
        QuestionMuhendislik q65 = new QuestionMuhendislik("Block caches or buffer caches are used","to improve disk performance","to handle interrupts","to increase the capacity of the main memory","to speed up main memory read operation","to improve disk performance","I");
        this.addQuestionMuhendislik(q65);
        QuestionMuhendislik q66 = new QuestionMuhendislik("Which of the following statements is false?","a small page size causes large page tables","internal fragmentation is increased with small pages","a large page size causes instructions and data that will not be referenced brought into primary storage","I/O transfers are more efficient with large pages","internal fragmentation is increased with small pages","I");
        this.addQuestionMuhendislik(q66);
        QuestionMuhendislik q67 = new QuestionMuhendislik("The action of parsing the source program into the proper syntactic classes is known as","syntax analysis","lexical analysis","interpretation analysis","general syntax analysis","lexical analysis","I");
        this.addQuestionMuhendislik(q67);
        QuestionMuhendislik q68 = new QuestionMuhendislik("Which, of the following is not true about the description of a decision table?","A decision table is easy to modify","A decision table is directly understood by the computer","A decision table is easy to understand","All of the above","A decision table is directly understood by the computer","I");
        this.addQuestionMuhendislik(q68);
        QuestionMuhendislik q69 = new QuestionMuhendislik("Trojan-Horse programs","are legitimate programs that allow unauthorized access","do not usually work","are hidden programs that do not show up on the system","usually are immediately discovered","are legitimate programs that allow unauthorized access","I");
        this.addQuestionMuhendislik(q69);
        QuestionMuhendislik q70 = new QuestionMuhendislik("When did IBM release the first version of disk operating system DOS version 1.0?","1981","1982","1983","1984","1981","I");
        this.addQuestionMuhendislik(q70);
        QuestionMuhendislik q71 = new QuestionMuhendislik("Which of the following is false about disk when compared to main memory?","non-volatile","longer storage capacity","lower price per bit","faster","faster","I");
        this.addQuestionMuhendislik(q71);
        QuestionMuhendislik q72 = new QuestionMuhendislik("Producer consumer problem can be solved using","semaphores","event counters","monitors","all of the above","all of the above","I");
        this.addQuestionMuhendislik(q72);
        QuestionMuhendislik q73 = new QuestionMuhendislik("Most of the microcomputer's operating systems like Apple DOS, MS DOS and PC DOS etc. are called disk operating systems because","they are memory resident","they are initially stored on disk","they are available on magnetic tapes","they are partly in primary memory and partly on disk","they are initially stored on disk","I");
        this.addQuestionMuhendislik(q73);
        QuestionMuhendislik q74 = new QuestionMuhendislik("The CPU, after receiving an interrupt from an I/O device","halts for a predetermined time","hands over control of address bus and data bus to the interrupting device","branches off to the interrupt service routine immediately","branches off to the interrupt service routine after completion of the current instruction","branches off to the interrupt service routine after completion of the current instruction","I");
        this.addQuestionMuhendislik(q74);
        QuestionMuhendislik q75 = new QuestionMuhendislik("Seeks analysis","is used for analyzing paging problems","is used for analyzing control-unit busy problems","is only shown on real-time displays","is used for analyzing device busy problems","is used for analyzing device busy problems","I");
        this.addQuestionMuhendislik(q75);
        QuestionMuhendislik q76 = new QuestionMuhendislik("Which is a permanent database in the general model of compiler?","Literal Table","Identifier Table","Terminal Table","Source code","Terminal Table","I");
        this.addQuestionMuhendislik(q76);
        QuestionMuhendislik q77 = new QuestionMuhendislik("What is the name of the technique in which the operating system of a computer executes several programs concurrently by switching back and forth between them?","Partitioning","Multitasking","Windowing","Paging","Multitasking","I");
        this.addQuestionMuhendislik(q77);
        QuestionMuhendislik q78 = new QuestionMuhendislik("Operating system","links a program with the subroutines it references","provides a layered, user-friendly interface","enables the programmer to draw a flowchart","all of the above","provides a layered, user-friendly interface","I");
        this.addQuestionMuhendislik(q78);
        QuestionMuhendislik q79 = new QuestionMuhendislik("Software that measures, monitors, analyzes, and controls real-world events is called:","system software","real-time software","scientific software","business software","real-time software","I");
        this.addQuestionMuhendislik(q79);
        QuestionMuhendislik q80 = new QuestionMuhendislik("The details of all external symbols and relocation formation (relocation list or map) is provided to linker by","Macro processor","Translator","Loader","Editor","Translator","I");
        this.addQuestionMuhendislik(q80);
        QuestionMuhendislik q81 = new QuestionMuhendislik("The macro processor must perform","recognize macro definitions and macro calls","save the macro definitions","expand macros calls and substitute arguments","all of the above","all of the above","I");
        this.addQuestionMuhendislik(q81);
        QuestionMuhendislik q82 = new QuestionMuhendislik("A development strategy whereby the executive control modules of a system are coded and tested first, is known as","Bottom-up development","Top-down development","Left-Right development","All of the above","Top-down development","I");
        this.addQuestionMuhendislik(q82);
        QuestionMuhendislik q83 = new QuestionMuhendislik("Which of the following is helpful in evaluating applications software what will best suit your needs?","recommendations by other users","computer magazines","objective software reviews","all of the above","all of the above","I");
        this.addQuestionMuhendislik(q83);
        QuestionMuhendislik q84 = new QuestionMuhendislik("What problem is solved by Dijkstra's banker's algorithm?","mutual exclusion","deadlock recovery ","deadlock avoidance","cache coherence","deadlock avoidance","I");
        this.addQuestionMuhendislik(q84);
        QuestionMuhendislik q85 = new QuestionMuhendislik("The dispatcher","actually schedules the tasks into the processor","puts tasks in I/O wait","is always small and simple","never changes task priorities","actually schedules the tasks into the processor","I");
        this.addQuestionMuhendislik(q85);
        QuestionMuhendislik q86 = new QuestionMuhendislik("System programs such as Compilers are designed so that they are","reenterable","non reusable","serially usable","recursive","reenterable","I");
        this.addQuestionMuhendislik(q86);
        QuestionMuhendislik q87 = new QuestionMuhendislik("IBM released its first PC in 1981. Can you name the operating system which was most popular at that time?","MS-DOS","PC-DOS","OS/360","CP/M","CP/M","I");
        this.addQuestionMuhendislik(q87);
        QuestionMuhendislik q88 = new QuestionMuhendislik("If the number of bits in a virtual address of a program is 16 and the page size is 0.5 K bytes, the number of pages in the virtual address space is","16","32","64","128","128","I");
        this.addQuestionMuhendislik(q88);
        QuestionMuhendislik q89 = new QuestionMuhendislik("Which table is a permanent database that has an entry for each terminal symbol.","Terminal table","Reductions","Identifier table","Literal table","Terminal table","I");
        this.addQuestionMuhendislik(q89);
        QuestionMuhendislik q90 = new QuestionMuhendislik("The function(s) of the Syntax phase is(are)","to recognize the major constructs of the language and to call the appropriate action routines that will generate the intermediate form or matrix for these constructs.","to build a literal table and an identifier table","to build a uniform symbol table","to parse the source program into the basic elements or tokens of the language.","to recognize the major constructs of the language and to call the appropriate action routines that will generate the intermediate form or matrix for these constructs.","I");
        this.addQuestionMuhendislik(q90);
        QuestionMuhendislik q91 = new QuestionMuhendislik("Swapping","works best with many small partitions","allows many programs to use memory simultaneously","allows each program in turn to use the memory","does not work with overlaying33","allows each program in turn to use the memory","I");
        this.addQuestionMuhendislik(q91);
        QuestionMuhendislik q92 = new QuestionMuhendislik("A disk scheduling algorithm in an operating system causes the disk arm to move back and forth across the disk surface in order to service all requests in its path. This is a","First come first served","Shortest Seek Time First (SSTE)","Scan","FIFO","Scan ","I");
        this.addQuestionMuhendislik(q92);
        QuestionMuhendislik q93 = new QuestionMuhendislik("A translator is best described as","an application software","a system software","a hardware component","all of the above","a system software","I");
        this.addQuestionMuhendislik(q93);
        QuestionMuhendislik q94 = new QuestionMuhendislik("Data encryption","is mostly used by public networks","is mostly used by financial networks","cannot be used by private installations","is not necessary, since data cannot be intercepted","is mostly used by financial networks","I");
        this.addQuestionMuhendislik(q94);
        QuestionMuhendislik q95 = new QuestionMuhendislik("What is the name given to the process of initializing a microcomputer with its operating system?","Cold booting","Booting","Warm booting","Boot recording","Booting","I");
        this.addQuestionMuhendislik(q95);
        QuestionMuhendislik q96 = new QuestionMuhendislik("The function(s) of the Storage Assignment is (are)","to assign storage to all variables referenced in the source program.","to assign storage to all temporary locations that are necessary for intermediate results","to assign storage to literals, and to ensure that the storage is allocate and appropriate locations are initialized.","all of the above","all of the above","I");
        this.addQuestionMuhendislik(q96);
        QuestionMuhendislik q97 = new QuestionMuhendislik("A Processor","is a device that performs a sequence of operations specified by instructions in memory.","is the device where information is stored","is a sequence of instructions","is typically characterized by interactive processing and time of the CPU's time to allow quick response to each user","is a device that performs a sequence of operations specified by instructions in memory","I");
        this.addQuestionMuhendislik(q97);
        QuestionMuhendislik q98 = new QuestionMuhendislik("With MS-DOS which command will divide the surface of the blank floppy disk into sectors and assign a unique address to each one?","FORMAT command","FAT command","VER command","CHKDSK command","FORMAT command","I");
        this.addQuestionMuhendislik(q98);
        QuestionMuhendislik q99 = new QuestionMuhendislik("Multiprogramming","is a method of memory allocation by which the program is subdivided into equal portions, or pages and core is subdivided into equal portions or blocks.","consists of those addresses that may be generated by a processor during execution of a computation","is a method of allocating processor time.","allows multiple programs to reside in separate areas of core at the time","allows multiple programs to reside in separate areas of core at the time","I");
        this.addQuestionMuhendislik(q99);
        QuestionMuhendislik q100 = new QuestionMuhendislik("A translator which reads an entire programme written in a high level language and converts it into machine language code is:","assembler","translator","compiler","system software","compiler","I");
        this.addQuestionMuhendislik(q100);
        QuestionMuhendislik q101=new QuestionMuhendislik("If the displayed system time and date is wrong, you can reset it using","Write","Calendar","Control Panel","Action Center","Control Panel","E");
        this.addQuestionMuhendislik(q101);
        QuestionMuhendislik q102=new QuestionMuhendislik("You should save your computer from","virus","worms","malwares","all of the above","all of the above","E");
        this.addQuestionMuhendislik(q102);
        QuestionMuhendislik q103=new QuestionMuhendislik("World Wide Web is being standardized by ","Worldwide INC","W3C","World Wide Consortium","World Wide Web Standard","W3C","E");
        this.addQuestionMuhendislik(q103);
        QuestionMuhendislik q104=new QuestionMuhendislik("Which of the following is a program group?","Accessories","MS WORD","Paint","SharePoint","Accessories","E");
        this.addQuestionMuhendislik(q104);
        QuestionMuhendislik q105= new QuestionMuhendislik("Which OS does not support more than one program at a time?","DOS","Linux","Windows","Unix","DOS","E");
        this.addQuestionMuhendislik(q105);
        QuestionMuhendislik q106= new QuestionMuhendislik("Linus is ","Open source","Windows","Costly","MAC","Open source","E");
        this.addQuestionMuhendislik(q106);
        QuestionMuhendislik q107=new QuestionMuhendislik("Which one is not an OS","P11","OS/2","Windows","Unix","P11","E");
        this.addQuestionMuhendislik(q107);
        QuestionMuhendislik q108= new QuestionMuhendislik("Which one is not an multitasking OS","Windows","Linux","Win NT","DOS","DOS","E");
        this.addQuestionMuhendislik(q108);
        QuestionMuhendislik q109= new QuestionMuhendislik("A user interface that is easy to use is","user happy","user friendly","user simple","none of these","user friendly","E");
        this.addQuestionMuhendislik(q109);
        QuestionMuhendislik q110= new QuestionMuhendislik("What is the function of radio button?","To select multiple option","To select single option","To select all option","All of above","To select single option","E");
        this.addQuestionMuhendislik(q110);
        QuestionMuhendislik q111= new QuestionMuhendislik("Which command is used to display contents of text file in DOS?","copy con","copy","type","dir","type","E");
        this.addQuestionMuhendislik(q111);
        QuestionMuhendislik q112= new QuestionMuhendislik("Essential file of MSDOS boot disk is:","COMMAND.COM","START.COM","TREE.COM","VER.COM","COMMAND.COM","E");
        this.addQuestionMuhendislik(q112);
        QuestionMuhendislik q113= new QuestionMuhendislik("Which command is used to see version of OS?","vol","version","ver","volume","ver","E");
        this.addQuestionMuhendislik(q113);
        QuestionMuhendislik q114= new QuestionMuhendislik("Which of the following are loaded in safe mode?","Keyboard Driver","Mouse Driver","VGA Driver","ALL","ALL","E");
        this.addQuestionMuhendislik(q114);
        QuestionMuhendislik q115=new QuestionMuhendislik("The bankers alorithm is used to","to rectify deadlock","to detect deadlock","to prevent deadlock","to slow deadlock","to prevent deadlock","E");
        this.addQuestionMuhendislik(q115);
        QuestionMuhendislik q116= new QuestionMuhendislik("Which of the following is drop down list?","List","Combo Box","Text Area","None","Combo Box","E");
        this.addQuestionMuhendislik(q116);
        QuestionMuhendislik q117=new QuestionMuhendislik("A page fault occurs when","the deadlock happens","the segmentation starts","the page is found in memory","the page is not found in memory","the page is not found in memory","E");
        this.addQuestionMuhendislik(q117);
        QuestionMuhendislik q118= new QuestionMuhendislik("Taskbar is used for","Navigation","Switching programs","Start a program","All of above","All of above","E");
        this.addQuestionMuhendislik(q118);
        QuestionMuhendislik q119= new QuestionMuhendislik("What is Dr.Watson?","IT Expert","Diagnosis Tool","Surgeon","None","IT Expert","E");
        this.addQuestionMuhendislik(q119);
        QuestionMuhendislik q120= new QuestionMuhendislik("The command used to create logical drive for specific location of disk","FDisk","Format","Subst","All of above","Subst","E");
        this.addQuestionMuhendislik(q120);
        QuestionMuhendislik q121= new QuestionMuhendislik("Running multiple programs at the same time is called","Multitasking","Background Tasking","Foreground Tasking","None of the above","Multitasking","E");
        this.addQuestionMuhendislik(q121);
        QuestionMuhendislik q122= new QuestionMuhendislik("Page stealing","is an sign of an efficient system","Is taking page frame from other working sets","Should be the turning goal","Is taking layer disk space for page in page out","Is taking page frame from other working sets","E");
        this.addQuestionMuhendislik(q122);
        QuestionMuhendislik q123= new QuestionMuhendislik("What do you mean by dialog box?","Interactive message box","Group of options","Set of controls","All of the above","All of the above","E");
        this.addQuestionMuhendislik(q123);
        QuestionMuhendislik q124= new QuestionMuhendislik("Dial up connection allows you to","Connect ISP","Internet","Server","All of above","Connect ISP","E");
        this.addQuestionMuhendislik(q124);
        QuestionMuhendislik q125= new QuestionMuhendislik("Which is not a system tool?","Folder","Backup","Scandisk","Format","Folder","E");
        this.addQuestionMuhendislik(q125);
        QuestionMuhendislik q126= new QuestionMuhendislik("Scandisk ","Checks the disk","Give information about disk","Run from DOS mode","All of the above","All of the above","E");
        this.addQuestionMuhendislik(q126);
        QuestionMuhendislik q127= new QuestionMuhendislik("Batch file is used to","Run program","Show the contents","run commands automatically","All of above","All of above","E");
        this.addQuestionMuhendislik(q127);
        QuestionMuhendislik q128= new QuestionMuhendislik("Which of the following is not process states?","New","Ready","Running","Finished","Finished","E");
        this.addQuestionMuhendislik(q128);
        QuestionMuhendislik q129= new QuestionMuhendislik("We can start the application from?","Log Off","Network Place","Recycle Bin","Run","Run","E");
        this.addQuestionMuhendislik(q129);
        QuestionMuhendislik q130= new QuestionMuhendislik("What you type at the DOS command prompt to return back to windows?","Command","Exit","Quit","Return","Exit","E");
        this.addQuestionMuhendislik(q130);
        QuestionMuhendislik q131= new QuestionMuhendislik("Which of the following is the part of the operating system?","Cell","FAT","Kernel","Disk","Kernel","E");
        this.addQuestionMuhendislik(q131);
        QuestionMuhendislik q132= new QuestionMuhendislik("Sleep is a good mode to use because","It saves power which in turn is saving money","It makes compuer fresh after it wakes up","It consumes low battery when you start it again","All of above","It saves power which in turn is saving money","E");
        this.addQuestionMuhendislik(q132);
        QuestionMuhendislik q133= new QuestionMuhendislik("The operating feature that integrates the file created in different application into WebPages","Web integration","Internet integration","Intranet integration","Hypertext integration","Web integration","E");
        this.addQuestionMuhendislik(q133);
        QuestionMuhendislik q134= new QuestionMuhendislik("What hole will allocates in Worst-Fit algorithm of memory management?","It allocates the smaller hole than required memory hole","It allocates the smallest hole from the available memory holes","It allocates the largest hole from the available memory holes","It allocates the exact same size memory hole","It allocates the largest hole from the available memory holes","E");
        this.addQuestionMuhendislik(q134);
        QuestionMuhendislik q135= new QuestionMuhendislik("BIOS is used by","Operating system","Compiler","Interpreter","Application software","Operating system","E");
        this.addQuestionMuhendislik(q135);
        QuestionMuhendislik q136= new QuestionMuhendislik("Commonly network of network is called","MS Word","MS Excel","Internet","MS Access","Internet","E");
        this.addQuestionMuhendislik(q136);
        QuestionMuhendislik q137= new QuestionMuhendislik("Find can be used to","Locate a program","Locate a document","Locate a network computer","All of above","All of above","E");
        this.addQuestionMuhendislik(q137);
        QuestionMuhendislik q138= new QuestionMuhendislik("Which of the following is the allocation method of a disk space?","Contiguous allocation","Linked allocation","Indexed allocation","All of the Above","All of the Above","E");
        this.addQuestionMuhendislik(q138);
        QuestionMuhendislik q139= new QuestionMuhendislik("When you cut or copy the text or picture, it stores temporarily in the","File","Clipboard","Icon","All of above","Clipboard","E");
        this.addQuestionMuhendislik(q139);
        QuestionMuhendislik q140= new QuestionMuhendislik("A tiny dot of light on the monitor is called","Silicon chip","Optical illusion","Icon","Pixel","Pixel","E");
        this.addQuestionMuhendislik(q140);
        QuestionMuhendislik q141= new QuestionMuhendislik("Who is called a supervisor of computer activity?","Memory","Operating System","I/O Devices","Control Unit","Operating System","E");
        this.addQuestionMuhendislik(q141);
        QuestionMuhendislik q142= new QuestionMuhendislik("Operating System manages","Memory","Processor","I/O devices","All of the above","All of the above","E");
        this.addQuestionMuhendislik(q142);
        QuestionMuhendislik q143= new QuestionMuhendislik("Which of the following concept is best to preventing page faults?","Paging","The working set","Hit ratios","Address location resolution","Paging","E");
        this.addQuestionMuhendislik(q143);
        QuestionMuhendislik q144= new QuestionMuhendislik("Which is not a valid property for attribute setting?","C","S","H","R","C","E");
        this.addQuestionMuhendislik(q144);
        QuestionMuhendislik q145= new QuestionMuhendislik("Virtual memory typically located on","RAM","CPU","Flash Card","Hard Drive","Hard Drive","E");
        this.addQuestionMuhendislik(q145);
        QuestionMuhendislik q146= new QuestionMuhendislik("Tree structure displays the","File only","Directory only","File and directory name","None of above","File and directory name","E");
        this.addQuestionMuhendislik(q146);
        QuestionMuhendislik q147= new QuestionMuhendislik("Press ____ key while booting to display Advanced Boot Menu","F8","F5","Del","F2","F8","E");
        this.addQuestionMuhendislik(q147);
        QuestionMuhendislik q148= new QuestionMuhendislik("Which operating system uses short file names?","Windows","Unix","DOS","MAC","DOS","E");
        this.addQuestionMuhendislik(q148);
        QuestionMuhendislik q149= new QuestionMuhendislik("What do you mean by Memory Compaction?","Combine multiple equal memory holes into one big hole","Combine multiple small memory holes into one big hole","Divide big memory hole into small holes","Divide memory hole by 2","Combine multiple small memory holes into one big hole","E");
        this.addQuestionMuhendislik(q149);
        QuestionMuhendislik q150= new QuestionMuhendislik("Copying a process from memory to disk to allow space for other processes is called","Swapping","Deadlock","Demand Paging","Page Fault","Swapping","E");
        this.addQuestionMuhendislik(q150);

        }


public void addQuestionMuhendislik(QuestionMuhendislik quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION3());
        values.put(KEY_ANSWER, quest.getANSWER3());
        values.put(KEY_OPTA, quest.getOPTA3());
        values.put(KEY_OPTB, quest.getOPTB3());
        values.put(KEY_OPTC, quest.getOPTC3());
        values.put(KEY_OPTD, quest.getOPTD3());
        values.put(KEY_CAT,quest.getCATEGORY3());
        // Inserting Row
        dbase.insert(TABLE_QUEST3, null, values);
        }


@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

public List<QuestionHukuk> getAllQuestions1(String tname, String lname)
        {
        List<QuestionHukuk> quesList1= new ArrayList<QuestionHukuk>();
            dbase=this.getReadableDatabase();

            Cursor cursor = dbase.rawQuery("SELECT * FROM questHukuk WHERE category = ?", new String[] {lname});

        // looping through all rows and adding to list
        if ( cursor.moveToFirst()) {
        do {


        QuestionHukuk quest1 = new QuestionHukuk();
        quest1.setID1(cursor.getInt(0));
        quest1.setQUESTION1(cursor.getString(1));
        quest1.setANSWER1(cursor.getString(2));
        quest1.setOPTA1(cursor.getString(3));
        quest1.setOPTB1(cursor.getString(4));
        quest1.setOPTC1(cursor.getString(5));
        quest1.setOPTD1(cursor.getString(6));
        quesList1.add(quest1);

        } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
        }

public List<QuestionEczacilik> getAllQuestions(String tname, String lname)
        {
        List<QuestionEczacilik> quesList1= new ArrayList<QuestionEczacilik>();
        String selectQuery1 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
        do {
        QuestionEczacilik quest1 = new QuestionEczacilik();
        quest1.setID(cursor.getInt(0));
        quest1.setQUESTION(cursor.getString(1));
        quest1.setANSWER(cursor.getString(2));
        quest1.setOPTA(cursor.getString(3));
        quest1.setOPTB(cursor.getString(4));
        quest1.setOPTC(cursor.getString(5));
        quest1.setOPTD(cursor.getString(6));
        quesList1.add(quest1);
        } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
        }

public List<QuestionIktisat> getAllQuestions2(String tname, String lname)
        {
        List<QuestionIktisat> quesList1= new ArrayList<QuestionIktisat>();
        String selectQuery1 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
        do {
        QuestionIktisat quest1 = new QuestionIktisat();
        quest1.setID2(cursor.getInt(0));
        quest1.setQUESTION2(cursor.getString(1));
        quest1.setANSWER2(cursor.getString(2));
        quest1.setOPTA2(cursor.getString(3));
        quest1.setOPTB2(cursor.getString(4));
        quest1.setOPTC2(cursor.getString(5));
        quest1.setOPTD2(cursor.getString(6));
        quesList1.add(quest1);
        } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
        }

public List<QuestionMuhendislik> getAllQuestions3(String tname ,String lname)
        {
        List<QuestionMuhendislik> quesList1= new ArrayList<QuestionMuhendislik>();
        String selectQuery1 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
        do {
        QuestionMuhendislik quest1 = new QuestionMuhendislik();
        quest1.setID3(cursor.getInt(0));
        quest1.setQUESTION3(cursor.getString(1));
        quest1.setANSWER3(cursor.getString(2));
        quest1.setOPTA3(cursor.getString(3));
        quest1.setOPTB3(cursor.getString(4));
        quest1.setOPTC3(cursor.getString(5));
        quest1.setOPTD3(cursor.getString(6));
        quesList1.add(quest1);
        } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
        }



public boolean insertScoreHukuk(int scoreHukuk, String tname, String cname,String userID) {




        Cursor c;
        SQLiteDatabase db1 = this.getWritableDatabase();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_UserID.toString(), userID);

        String sqlSelectQuery="SELECT "+ SCORE_COUNT+" , " +SCORE_KEY_SCORE+" FROM "+ TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST1 +"' AND "+ SCORE_KEY_CAT + " = '" + "B" + "' AND "+ SCORE_UserID + " = '"+ userID +"'";
        c=db1.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();


        long resultscore=0;
        int x=0;
        int total_score=0;


        if( c != null && c.moveToFirst() ){

                x=c.getInt(0);
                total_score=c.getInt(1);





                        total_score = (total_score + scoreHukuk) / (x + 1);


                contentValues.put(SCORE_KEY_SECTION.toString(),tname);
                contentValues.put(SCORE_KEY_CAT.toString(),cname);
                contentValues.put(SCORE_UserID.toString(), userID);

                contentValues.put(SCORE_KEY_SCORE.toString(), total_score);
                contentValues.put(SCORE_COUNT, x + 1);
                String whereClause = SCORE_KEY_SECTION + " = ? AND " + SCORE_KEY_CAT + " = ? AND " + SCORE_UserID + " = ?";
                final String whereArgs[] = {TABLE_QUEST1, "B", userID};

                resultscore = db.update(TABLE_SCORE, contentValues, whereClause, whereArgs);


        }else{


                contentValues.put(SCORE_KEY_SECTION.toString(),tname);
                contentValues.put(SCORE_KEY_CAT.toString(),cname);
                contentValues.put(SCORE_UserID.toString(), userID);
                contentValues.put(SCORE_COUNT, 1);
                contentValues.put(SCORE_KEY_SCORE.toString(), scoreHukuk);

                resultscore = db.insert(TABLE_SCORE, null, contentValues);
        }



        if(resultscore == -1)
        return false;
        else
        return true;
        }

public boolean insertScoreEczacilik(int scoreEczacilik, String tname, String cname,String userID){
        Cursor c;
        SQLiteDatabase db1 = this.getWritableDatabase();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_UserID.toString(), userID);

        String sqlSelectQuery="SELECT "+ SCORE_COUNT+" , " +SCORE_KEY_SCORE+" FROM "+ TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST +"' AND "+ SCORE_KEY_CAT + " = '" + "B" + "' AND "+ SCORE_UserID + " = '"+ userID +"'";
        c=db1.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();


        long resultscore=0;
        int x=0;
        int total_score=0;


        if( c != null && c.moveToFirst() ){

                x=c.getInt(0);
                total_score=c.getInt(1);





                total_score = (total_score + scoreEczacilik) / (x + 1);


                contentValues.put(SCORE_KEY_SECTION.toString(),tname);
                contentValues.put(SCORE_KEY_CAT.toString(),cname);
                contentValues.put(SCORE_UserID.toString(), userID);

                contentValues.put(SCORE_KEY_SCORE.toString(), total_score);
                contentValues.put(SCORE_COUNT, x + 1);
                String whereClause = SCORE_KEY_SECTION + " = ? AND " + SCORE_KEY_CAT + " = ? AND " + SCORE_UserID + " = ?";
                final String whereArgs[] = {TABLE_QUEST, "B", userID};

                resultscore = db.update(TABLE_SCORE, contentValues, whereClause, whereArgs);


        }else{


                contentValues.put(SCORE_KEY_SECTION.toString(),tname);
                contentValues.put(SCORE_KEY_CAT.toString(),cname);
                contentValues.put(SCORE_UserID.toString(), userID);
                contentValues.put(SCORE_COUNT, 1);
                contentValues.put(SCORE_KEY_SCORE.toString(), scoreEczacilik);

                resultscore = db.insert(TABLE_SCORE, null, contentValues);
        }



        if(resultscore == -1)
                return false;
        else
                return true;
}
public boolean insertScoreIktisat(int scoreIktisat, String tname, String cname,String userID) {
    Cursor c;
    SQLiteDatabase db1 = this.getWritableDatabase();
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();

    contentValues.put(SCORE_KEY_SECTION.toString(),tname);
    contentValues.put(SCORE_KEY_CAT.toString(),cname);
    contentValues.put(SCORE_UserID.toString(), userID);

    String sqlSelectQuery="SELECT "+ SCORE_COUNT+" , " +SCORE_KEY_SCORE+" FROM "+ TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST2 +"' AND "+ SCORE_KEY_CAT + " = '" + "B" + "' AND "+ SCORE_UserID + " = '"+ userID +"'";
    c=db1.rawQuery(sqlSelectQuery, null);
    c.moveToFirst();


    long resultscore=0;
    int x=0;
    int total_score=0;


    if( c != null && c.moveToFirst() ){

        x=c.getInt(0);
        total_score=c.getInt(1);





        total_score = (total_score + scoreIktisat) / (x + 1);


        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_UserID.toString(), userID);

        contentValues.put(SCORE_KEY_SCORE.toString(), total_score);
        contentValues.put(SCORE_COUNT, x + 1);
        String whereClause = SCORE_KEY_SECTION + " = ? AND " + SCORE_KEY_CAT + " = ? AND " + SCORE_UserID + " = ?";
        final String whereArgs[] = {TABLE_QUEST2, "B", userID};

        resultscore = db.update(TABLE_SCORE, contentValues, whereClause, whereArgs);


    }else{


        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_UserID.toString(), userID);
        contentValues.put(SCORE_COUNT, 1);
        contentValues.put(SCORE_KEY_SCORE.toString(), scoreIktisat);

        resultscore = db.insert(TABLE_SCORE, null, contentValues);
    }



    if(resultscore == -1)
        return false;
    else
        return true;
}

public boolean insertScoreMuhendislik(int scoreMuhendislik, String tname,String cname,String userID){
        Cursor c;
        SQLiteDatabase db1 = this.getWritableDatabase();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_CAT.toString(),cname);
        contentValues.put(SCORE_UserID.toString(), userID);

        String sqlSelectQuery="SELECT "+ SCORE_COUNT+" , " +SCORE_KEY_SCORE+" FROM "+ TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST3 +"' AND "+ SCORE_KEY_CAT + " = '" + "B" + "' AND "+ SCORE_UserID + " = '"+ userID +"'";
        c=db1.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();


        long resultscore=0;
        int x=0;
        int total_score=0;


        if( c != null && c.moveToFirst() ){

                x=c.getInt(0);
                total_score=c.getInt(1);





                total_score = (total_score + scoreMuhendislik) / (x + 1);


                contentValues.put(SCORE_KEY_SECTION.toString(),tname);
                contentValues.put(SCORE_KEY_CAT.toString(),cname);
                contentValues.put(SCORE_UserID.toString(), userID);

                contentValues.put(SCORE_KEY_SCORE.toString(), total_score);
                contentValues.put(SCORE_COUNT, x + 1);
                String whereClause = SCORE_KEY_SECTION + " = ? AND " + SCORE_KEY_CAT + " = ? AND " + SCORE_UserID + " = ?";
                final String whereArgs[] = {TABLE_QUEST3, "B", userID};

                resultscore = db.update(TABLE_SCORE, contentValues, whereClause, whereArgs);


        }else{


                contentValues.put(SCORE_KEY_SECTION.toString(),tname);
                contentValues.put(SCORE_KEY_CAT.toString(),cname);
                contentValues.put(SCORE_UserID.toString(), userID);
                contentValues.put(SCORE_COUNT, 1);
                contentValues.put(SCORE_KEY_SCORE.toString(), scoreMuhendislik);

                resultscore = db.insert(TABLE_SCORE, null, contentValues);
        }



        if(resultscore == -1)
                return false;
        else
                return true;
}


        public int getHukukScoreCount(String userId) {
                Cursor c;
                SQLiteDatabase db = this.getWritableDatabase();
                String sqlSelectQuery="SELECT MAX(" + SCORE_COUNT + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST1 +"' AND "+ SCORE_KEY_CAT + " = '" + "B" + "' AND "+ SCORE_UserID + " = '"+ userId +"'";
                c=db.rawQuery(sqlSelectQuery, null);
                c.moveToFirst();
                int x=c.getInt(0);
                return x;
        }
        public int getMuhendislikScoreCount(String userId) {
                Cursor c;
                SQLiteDatabase db = this.getWritableDatabase();
                String sqlSelectQuery="SELECT MAX(" + SCORE_COUNT + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST3 +"' AND "+ SCORE_KEY_CAT + " = '" + "B" + "' AND "+ SCORE_UserID + " = '"+ userId +"'";
                c=db.rawQuery(sqlSelectQuery, null);
                c.moveToFirst();
                int x=c.getInt(0);
                return x;
        }
        public int getEczacilikScoreCount(String userId) {
                Cursor c;
                SQLiteDatabase db = this.getWritableDatabase();
                String sqlSelectQuery="SELECT MAX(" + SCORE_COUNT + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST +"' AND "+ SCORE_KEY_CAT + " = '" + "B" + "' AND "+ SCORE_UserID + " = '"+ userId +"'";
                c=db.rawQuery(sqlSelectQuery, null);
                c.moveToFirst();
                int x=c.getInt(0);
                return x;
        }
        public int getIktisatScoreCount(String userId) {
                Cursor c;
                SQLiteDatabase db = this.getWritableDatabase();
                String sqlSelectQuery="SELECT MAX(" + SCORE_COUNT + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST2 +"' AND "+ SCORE_KEY_CAT + " = '" + "B" + "' AND "+ SCORE_UserID + " = '"+ userId +"'";
                c=db.rawQuery(sqlSelectQuery, null);
                c.moveToFirst();
                int x=c.getInt(0);
                return x;
        }



public int getScoreHukuk(String userId) {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST1 +"' AND "+ SCORE_KEY_CAT + " = '" + "B" + "' AND "+ SCORE_UserID + " = '"+ userId +"'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
        }

public int getScoreEczacilik(String userId) {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST +"' AND "+ SCORE_KEY_CAT  + " = '" + "B" + "' AND "+ SCORE_UserID + " = '"+ userId +"'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
        }



public int getScoreIktisat(String userId) {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST2 +"' AND "+ SCORE_KEY_CAT  + " = '" + "B" + "' AND "+ SCORE_UserID + " = '"+ userId +"'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        return x;
        }


public int getScoreMuhendislik(String userId) {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST3+"' AND "+ SCORE_KEY_CAT + " = '" + "B" + "' AND "+ SCORE_UserID + " = '"+ userId +"'";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);

        return x;
        }

        public int deleteQuestionMuhendislik(int qID) {
                Cursor c;
                SQLiteDatabase db = this.getWritableDatabase();
                String whereClause = KEY_ID + " = ?";
                final String whereArgs[] = {String.valueOf(qID)};

                return db.delete(TABLE_QUEST3,whereClause,whereArgs);
        }
        public int deleteQuestionEczacilik(int qID) {
                Cursor c;
                SQLiteDatabase db = this.getWritableDatabase();
                String whereClause = KEY_ID + " = ?";
                final String whereArgs[] = {String.valueOf(qID)};

                return db.delete(TABLE_QUEST,whereClause,whereArgs);
        }
        public int deleteQuestionIktisat(int qID) {
                Cursor c;
                SQLiteDatabase db = this.getWritableDatabase();
                String whereClause = KEY_ID + " = ?";
                final String whereArgs[] = {String.valueOf(qID)};

                return db.delete(TABLE_QUEST2,whereClause,whereArgs);
        }
        public int deleteQuestionHukuk(int qID) {
                Cursor c;
                SQLiteDatabase db = this.getWritableDatabase();
                String whereClause = KEY_ID + " = ?";
                final String whereArgs[] = {String.valueOf(qID)};

                return db.delete(TABLE_QUEST1,whereClause,whereArgs);




        }


        }

