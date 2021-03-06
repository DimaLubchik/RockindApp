 package com.example.myapplication;
import android.media.Image;

import java.io.LineNumberReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Exercises {
    private static final String[][] WarmUp  = {{"Растяжка_1","Растяжка_2"},{"гимнастика_1","Гимнастика_2"},{"Бег_1","Бег_2"},{"Отжимания_1","Отжимания-2"}};
    private static final String[][] ChestEx  = {{"Отжимания"},{"Отжимания","Брусья"},{"Отжимания hard"},{"Отжимания hard","Брусья-hard"}};
    private static final String[][] EnduranceEx  = {{"Бег"},{"Бег","Бёрпи"},{"Бег hard"},{"Бег hard","Бёрпи hard"}};
    private static final String[][] AbsEx  = {{"Пресс"},{"Пресс","Скручивания"},{"Пресс hard"},{"Пресс hard","Скручивания hard"}};
    private static final String[][] CoreEx  = {{"Лодочка"},{"Лодочка","Планка"},{"Лодочка hard"},{"Лодочка hard","Планка hard"}};
    private static final String[][] LegsEx  = {{"Приседания"},{"Приседания","Бег"},{"Приседания hard"},{"Приседания hard","Бег hard"}};
    public Exercises(){
        createArms();
        createProgramsForDifferentLevels();
    }

    public  HashMap<String, List<Exercise>> Arms=new HashMap<>();
    public  ArrayList<String> ArmsMuscles= new ArrayList<>();
    public  HashMap<Integer, TrainingProgram> ArmsProgramsByLevel= new HashMap<>();


    public void createProgramsForDifferentLevels()
    {
        createArmsPrograms();

    }
    //Создает программы для груди для разных уровней подготовленности
    public void createArmsPrograms()
    {   //First level
        List<Exercise> temp_1=new ArrayList<>();
        temp_1.add(new Exercise("Подъем штанги на бицепс","Использование изогнутой штанги усиливает вовлечение бицепса в работу, поскольку при легком развороте ладони его внутренняя часть более активно включается в движение. Результат выполнения такой вариации упражнения — более объемный и «шарообразный» бицепс.",1,R.drawable.stanganagrud));
        temp_1.add(new Exercise("Подъем гантелей «молоток»"," Чем сильнее при выполнении упражнения вы разворачиваете руку, тем заметнее в работу включается короткая часть бицепса. Однако следите за тем, чтобы корпус не раскачивался, а двигалось исключительно предплечье — локоть должен быть зафиксирован, однако не прижат плотно к телу.",2,R.drawable.gantelunolotok));
        temp_1.add(new Exercise("Обратные отжимания на трицепс","Вы можете выполнять упражнение в зале, дома или на отдыхе – оно не требует какого-то специального оборудования. Отжимания можно делать в упоре на скамью, стул или диван или даже лавку в парке. С использованием отягощения также проблем не возникает. Вы можете увеличить нагрузку при помощи гантели, блина от штанги или любого другого увесистого предмета, хоть бутылки с водой.",3,R.drawable.otgimaniinatriceps));
        String workingMuscles="triceps,biceps";
        String time =" 5 minutes each exercise";
        String structure="Circle training";
        TrainingProgram program_1=new TrainingProgram(workingMuscles,time,structure,temp_1);
        ArmsProgramsByLevel.put(1,program_1);
        //Second level
        List<Exercise> temp_2=new ArrayList<>();
        temp_2.add(new Exercise("Жим гантели из-за головы ","Выжимать гантели можно как синхронно, так и по очереди каждой рукой, особенно, если приходится работать с большими весами. Обратите внимание, что работая каждой рукой по отдельности нужно будет особое внимание уделить положению корпуса, не допуская его движения.Жим из-за головы\n" +
                "\n" +
                "Учитывая тот факт, что упражнение эффективно за счет увеличения амплитуды движения, в нижней точке снаряды нужно стараться опускать максимально низко.",1,R.drawable.izgolov));
        temp_2.add(new Exercise("Тяга к подбородку","Тяга к подбородку — базовое упражнения для тренировки дельтовидных мышц (главным образом средней головки). В упражнении также участвует трапециевидные мышцы.",2,R.drawable.tigakpod));
        temp_2.add(new Exercise("Вис","Верхним захватом взяться за турник. Повиснуть на перекладине турника, расположив ладони на ширине плеч. За один подход желательно провисеть от одной до пяти минут.",3,R.drawable.vis));
        workingMuscles="triceps,biceps";
        time =" 5 minutes each exercise";
        structure="Circle training";
        TrainingProgram program_2=new TrainingProgram(workingMuscles,time,structure,temp_2);
        ArmsProgramsByLevel.put(2,program_2);
        List<Exercise> temp_3=new ArrayList<>();
        temp_3.add(new Exercise("Отжимания на брусьях","Основную нагрузку отжимания на брусьях создают на мышцы задней поверхности плеча, или трицепсы. ... Так как грудь и трицепс работают в паре – чем больше нагружается грудь, тем меньше задействуется трицепс и наоборот. Грудные мышцы больше и сильнее, поэтому при первой же возможности они перетягивают нагрузку на себя.",2,R.drawable.brusyah));
        temp_3.add(new Exercise("Подъем штанги на бицепс","Использование изогнутой штанги усиливает вовлечение бицепса в работу, поскольку при легком развороте ладони его внутренняя часть более активно включается в движение. Результат выполнения такой вариации упражнения — более объемный и «шарообразный» бицепс.",1,R.drawable.stanganagrud));
        temp_3.add(new Exercise("Тяга штанги на лавке к груди лёжа","Тяга к груди в положении лёжа на животе отлично прокачивает трапецию, особенно верхнюю и среднюю её части. Кроме того, в отличие от обычной тяги штанги в наклоне, это движение не позволяет вам читерить, меняя наклон тела.",3,R.drawable.tiganalavk));
        workingMuscles="triceps,biceps";
        time =" 5 minutes each exercise";
        structure="Circle training";
        TrainingProgram program_3=new TrainingProgram(workingMuscles,time,structure,temp_3);
        ArmsProgramsByLevel.put(3,program_3);
        List<Exercise> temp_4=new ArrayList<>();
        temp_4.add(new Exercise("Французский жим","Это одно из лучших упражнений для накачки трицепса. Оно позволяет акцентировать нагрузку на сокращении длинного и медиального пучка, а именно они и задают визуальную «массивность» руки. Для этого опускайте снаряд максимально низко и делайте в нижней точке небольшую паузу.\n" +
                "\n" +
                "Помните, что такой вариант выполнения упражнения травмоопасен и требует хорошей растяжки, поэтому нужно адекватно расценивать свои силы и не перебарщивать с рабочими весами. Большие веса (примерно от 50 кг) также с гарантией «убьют» ваши локти. Поэтому данное упражнение нужно ставить вторым или третьим в своей программе и делать максимально технично.",6,R.drawable.franzys));
        temp_4.add(new Exercise("Шраги со штангой за спиной","Шраги отлично прорабатывают верх трапеций, создают мышечную основу для правильной осанки. Выполнять упражнение следует заканчивая тренировку на трапеции, 3 сета по 10 повторений.\n" +
                "\n" +
                "\n" +
                "- Встать прямо. Штангу нужно подать сзади, ладони направлены назад. Руки выпрямлены, штанга сзади на уровне ягодиц.\n" +
                "\n" +
                "- Сделать вдох, задержать дыхание, поднять плечи, не помогая себе руками и не сгибая локти.\n" +
                "\n" +
                "- Задержаться в верхней точке, максимально напрягая мышцу трапеции.\n" +
                "\n" +
                "- Сделать выдох и возвратиться в начальное положение.",4,R.drawable.shragszaspin));
        temp_4.add(new Exercise("Молотковые сгибания","Молотковые сгибания считаются формирующими для мышц рук. Воздействует на боковую (наружную) головку бицепса, отлично прорабатывает брахиалис. Также нагрузка ложится на внешнюю часть предплечья, плечелучевую мышцу.\n" +
                "\n" +
                "В упражнениях со штангой штангу можно заменить на гантели. В случаях с разгибанием и сгибанием рук в запястьях более эффективно будет выполнять упражнение каждой рукой отдельно.",4,R.drawable.molot));
        workingMuscles="triceps,biceps";
        time =" 5 minutes each exercise";
        structure="Circle training";
        TrainingProgram program_4=new TrainingProgram(workingMuscles,time,structure,temp_4);
        ArmsProgramsByLevel.put(4,program_4);

    }

    public  void createArms()
    {
        ArmsMuscles.add("Бицепс");
        ArmsMuscles.add("Трицепс");//Brachioradial
        ArmsMuscles.add("Плечелучевая мышца");
        ArmsMuscles.add("Трапеции");//Trapeze
        ArmsMuscles.add("Предплечья");//Forearms
        ArmsMuscles.add("Локтевая мышца");//Ulnar
        List<Exercise> biceps= new ArrayList<>();
        biceps.add(new Exercise("Подъем штанги на бицепс","Использование изогнутой штанги усиливает вовлечение бицепса в работу, поскольку при легком развороте ладони его внутренняя часть более активно включается в движение. Результат выполнения такой вариации упражнения — более объемный и «шарообразный» бицепс.",1,R.drawable.stanganagrud));
        biceps.add(new Exercise("Подъем гантелей «молоток»"," Чем сильнее при выполнении упражнения вы разворачиваете руку, тем заметнее в работу включается короткая часть бицепса. Однако следите за тем, чтобы корпус не раскачивался, а двигалось исключительно предплечье — локоть должен быть зафиксирован, однако не прижат плотно к телу.",2,R.drawable.gantelunolotok));
        biceps.add(new Exercise("Обратные отжимания на трицепс","Вы можете выполнять упражнение в зале, дома или на отдыхе – оно не требует какого-то специального оборудования. Отжимания можно делать в упоре на скамью, стул или диван или даже лавку в парке. С использованием отягощения также проблем не возникает. Вы можете увеличить нагрузку при помощи гантели, блина от штанги или любого другого увесистого предмета, хоть бутылки с водой.",3,R.drawable.otgimaniinatriceps));
        biceps.add(new Exercise("Подтягивания обратным хватом","Обратный хват с узким расположением рук позволяет отработать не только бицепсы, но и нижнюю часть широчайших мышц спины. Перед выполнением упражнения следует положить ладони на перекладину на наименьшем расстоянии друг от друга, развернув их на себя и закрыв «замком» больших пальцев.",4,R.drawable.obratnpodt));
        biceps.add(new Exercise("Подъем штанги на бицепс обратным хватом","Выполнение упражнения: Удерживая локти и плечи неподвижными согните руки в локтях подняв штангу по дуге к плечам. Остановите штангу, когда они почти дойдет до груди. Сделайте паузу, напрягая при этом все мышцы рук, потом плавно опустите снаряд по той же траектории (по дуге) в исходное положение.",5,R.drawable.obrtshtang));
        List<Exercise> brachioradial = new ArrayList<>();
        brachioradial.add(new Exercise("Вис","Верхним захватом взяться за турник. Повиснуть на перекладине турника, расположив ладони на ширине плеч. За один подход желательно провисеть от одной до пяти минут.",1,R.drawable.vis));
        brachioradial.add(new Exercise("Сгибание рук обратным хватом","Техника выполнения упражнения сгибания рук обратным хватом\n" +
                "Вы держите штангу пронированным хватом, то есть костяшками пальцев вверх; На выдохе руки сгибаются в локтях, и штанга приводится к плечам; Движение выполняется без раскачки корпусом и толчков ногами; читинг рекомендуется убрать.",2,R.drawable.obthv2));
        brachioradial.add(new Exercise("Подтягивания прямым узким хватом","Подтягивания узким прямым хватом позволяют распределить часть нагрузки с двуглавой на плечевую мышцу (брахиалис). При параллельном хвате работают широчайшие мышцы (их нижняя область). Но если ваша первостепенная цель — широчайшие, то лучше использовать подтягивания широким хватом.",3,R.drawable.uspodt));
        List<Exercise> triceps= new ArrayList<>();
        triceps.add(new Exercise("Отжимания широким хватом","Отжимания от пола широким хватом – это традиционный вид упражнения, при котором руки ставятся на пол на ширину плеч и больше. Упражнение подходит абсолютно всем спортсменам любого пола.",1,R.drawable.otgshirhv));
        triceps.add(new Exercise("Отжимания на брусьях","Основную нагрузку отжимания на брусьях создают на мышцы задней поверхности плеча, или трицепсы. ... Так как грудь и трицепс работают в паре – чем больше нагружается грудь, тем меньше задействуется трицепс и наоборот. Грудные мышцы больше и сильнее, поэтому при первой же возможности они перетягивают нагрузку на себя.",2,R.drawable.brusyah));
        triceps.add(new Exercise("Жим гантели из-за головы ","Выжимать гантели можно как синхронно, так и по очереди каждой рукой, особенно, если приходится работать с большими весами. Обратите внимание, что работая каждой рукой по отдельности нужно будет особое внимание уделить положению корпуса, не допуская его движения.Жим из-за головы\n" +
                "\n" +
                "Учитывая тот факт, что упражнение эффективно за счет увеличения амплитуды движения, в нижней точке снаряды нужно стараться опускать максимально низко.",3,R.drawable.izgolov));
        triceps.add(new Exercise("Разгибание рук с гантелями в наклоне","При помощи этого упражнения можно задействовать не только трицепсы, но и задний пучок дельтовидных мышц. Эти мышцы маленькие и слабые, поэтому большой вес использовать не следует.\n" +
                "\n" +
                "Наклонившись вперёд, согните руки с гантелями в локтях под прямым углом и держите их близко к телу. Работать должны только предплечья, поэтому не следует менять угол наклона спины и двигать руками.",5,R.drawable.razgibani));
        triceps.add(new Exercise("Французский жим","Это одно из лучших упражнений для накачки трицепса. Оно позволяет акцентировать нагрузку на сокращении длинного и медиального пучка, а именно они и задают визуальную «массивность» руки. Для этого опускайте снаряд максимально низко и делайте в нижней точке небольшую паузу.\n" +
                "\n" +
                "Помните, что такой вариант выполнения упражнения травмоопасен и требует хорошей растяжки, поэтому нужно адекватно расценивать свои силы и не перебарщивать с рабочими весами. Большие веса (примерно от 50 кг) также с гарантией «убьют» ваши локти. Поэтому данное упражнение нужно ставить вторым или третьим в своей программе и делать максимально технично.",6,R.drawable.franzys));
        List<Exercise> trapeze= new ArrayList<>();
        trapeze.add(new Exercise("Шраги с гантелями описание","Упражнение шраги с гантелями одинаково полезно как для увеличения силы наших трапеций, что способствует повышению нашего результата в базовых упражнениях, выполняемых со штангой (становой тяге, швунгах, взятии штанги на грудь и т.д.), так и для набора мышечной массы всего плечевого пояса.",1,R.drawable.shragign));
        trapeze.add(new Exercise("Тяга к подбородку","Тяга к подбородку — базовое упражнения для тренировки дельтовидных мышц (главным образом средней головки). В упражнении также участвует трапециевидные мышцы.",2,R.drawable.tigakpod));
        trapeze.add(new Exercise("Тяга штанги на лавке к груди лёжа","Тяга к груди в положении лёжа на животе отлично прокачивает трапецию, особенно верхнюю и среднюю её части. Кроме того, в отличие от обычной тяги штанги в наклоне, это движение не позволяет вам читерить, меняя наклон тела.",3,R.drawable.tiganalavk));
        trapeze.add(new Exercise("Шраги со штангой за спиной","Шраги отлично прорабатывают верх трапеций, создают мышечную основу для правильной осанки. Выполнять упражнение следует заканчивая тренировку на трапеции, 3 сета по 10 повторений.\n" +
                "\n" +
                "\n" +
                "- Встать прямо. Штангу нужно подать сзади, ладони направлены назад. Руки выпрямлены, штанга сзади на уровне ягодиц.\n" +
                "\n" +
                "- Сделать вдох, задержать дыхание, поднять плечи, не помогая себе руками и не сгибая локти.\n" +
                "\n" +
                "- Задержаться в верхней точке, максимально напрягая мышцу трапеции.\n" +
                "\n" +
                "- Сделать выдох и возвратиться в начальное положение.",4,R.drawable.shragszaspin));
        List<Exercise> forearms= new ArrayList<>();
        forearms.add(new Exercise("Вис","Верхним захватом взяться за турник. Повиснуть на перекладине турника, расположив ладони на ширине плеч. За один подход желательно провисеть от одной до пяти минут.",1,R.drawable.vis));
        forearms.add(new Exercise("Сгибание и разгибание кистей со штангой","Сгибание кистей со штангой, наряду с разгибаниями используется для развития мышц предплечий и тренировки силы хвата, без которой невозможен прогресс во многих силовых упражнениях. Сгибание и разгибание кистей можно выполнять в зале или в домашних условиях, используя как штангу, так и любой другой «увесистый» инвентарь.Сгибания и разгибания запястий выполняются с максимальным количеством повторов и подходов. В качестве опоры можно использовать специальную тумбу, подставку, скамью, собственные бедра. Отягощение следует брать небольшое (мышцы довольно мелкие). ",2,R.drawable.sgraz));
        forearms.add(new Exercise("Сгибание рук обратным хватом","Обратное сгибание рук со штангой стоя – это формирующее упражнение, воздействующее на внешнюю часть мышц предплечья, в частности на плечелучевую мышцу. Также нагрузка ложится на брахиалис и бицепс.",3,R.drawable.obthv2));
        forearms.add(new Exercise("Молотковые сгибания","Молотковые сгибания считаются формирующими для мышц рук. Воздействует на боковую (наружную) головку бицепса, отлично прорабатывает брахиалис. Также нагрузка ложится на внешнюю часть предплечья, плечелучевую мышцу.\n" +
                "\n" +
                "В упражнениях со штангой штангу можно заменить на гантели. В случаях с разгибанием и сгибанием рук в запястьях более эффективно будет выполнять упражнение каждой рукой отдельно.",4,R.drawable.molot));
        List<Exercise> ulnar= new ArrayList<>();
        ulnar.add(new Exercise("Французский жим","Это одно из лучших упражнений для накачки трицепса. Оно позволяет акцентировать нагрузку на сокращении длинного и медиального пучка, а именно они и задают визуальную «массивность» руки. Для этого опускайте снаряд максимально низко и делайте в нижней точке небольшую паузу.\n" +
                "\n" +
                "Помните, что такой вариант выполнения упражнения травмоопасен и требует хорошей растяжки, поэтому нужно адекватно расценивать свои силы и не перебарщивать с рабочими весами. Большие веса (примерно от 50 кг) также с гарантией «убьют» ваши локти. Поэтому данное упражнение нужно ставить вторым или третьим в своей программе и делать максимально технично.",1,R.drawable.franzys));
        ulnar.add(new Exercise("Разгибание гантели из-за головы","Можно выполнять стоя, можно выполнять сидя. Исходное положение: спина и шея ровные, необходимо напрячь мышцы пресса, чтобы не было сильного прогиба в пояснице(в случае когда выполняется стоя), плечи в нейтральном положении, рука поднята вверх над головой. Плечевой сустав и локтевой сустав находятся в одной плоскости перпендикулярной полу. Задача опускать гантель за голову, затем возвращать обратно при помощи разгибания в локтевом суставе. Плечевая кость почти перпендикулярна горизонту, можно для устойчивости придерживать её другой рукой. Старайтесь избегать слишком амплитудного движения в плечевом суставе.",2,R.drawable.raz1gn));
        ulnar.add(new Exercise("Сгибание рук с гантелями","Можно делать упражнение стоя, можно сидя. Во втором варианте будет больше точек опоры и меньше возможности помогать остальным телом, что распределит нагрузку более акцентированно на рабочие мышцы. Исходное положение: руки вдоль туловища, спина и шея ровные, плечи опущены, ладони смотрят во внутрь(к телу, как на рисунке). Начинается движение со сгибания в локтевом суставе/подъёмом гантелей перед собой, и одновременно с этим происходит супинация предплечья, которая заканчивается примерно в тот момент, когда предплечье будет параллельно полу. Т.е. вначале движения ладони направлены во внутрь, к концу движения ладони смотрят вперёд. И как только вы начали движение, начинаете супинировать предплечье, примерно на половине пути ладонь должна уже смотреть вперёд. Локти при этом смотрят строго вниз, т.е. плечевая кость максимально перпендикулярна полу. Если же вы начнёте сильно выводить локти вперёд, работать уже будет плечевой сустав и часть нагрузки уйдёт на переднюю дельту и клювовидно-плечевую мышцу, но если слегка вывести локти, то это даст бицепсу дополнительное сокращение.",3,R.drawable.sgibgant));
        Arms.put(ArmsMuscles.get(0),biceps);//"Biceps"->biceps
        Arms.put(ArmsMuscles.get(1),triceps);
        Arms.put(ArmsMuscles.get(2),brachioradial);//"Biceps"-> shoulders
        Arms.put(ArmsMuscles.get(3),trapeze);
        Arms.put(ArmsMuscles.get(4),forearms);
        Arms.put(ArmsMuscles.get(5),ulnar);
    }

  //  Image p=new Image("C:/");
  //  Exercise pushUp=new Exercise("Отжимания","Лягьте встаньте",9,p);
   // ArrayList<Exercise> Exs=new ArrayList<>();
   // Exs.add(new Exercise("Отжимания","Лягьте встаньте",9,p));
  /*  public static LinkedHashSet<String> getChestExercises()
    {
        return (LinkedHashSet<String>) new LinkedHashSet<>(Arrays.asList(ChestEx));
    }
    public static LinkedHashSet<String> getEnduranceExercises()
    {
        return (LinkedHashSet<String>) new LinkedHashSet<>(Arrays.asList(EnduranceEx));
    }
    public static LinkedHashSet<String> getAbsExercises()
    {
        return (LinkedHashSet<String>) new LinkedHashSet<>(Arrays.asList(AbsEx));
    }
    public static LinkedHashSet<String> getCoreExercises()
    {
        return (LinkedHashSet<String>) new LinkedHashSet<>(Arrays.asList(CoreEx));
    }
    public static LinkedHashSet<String> getLegsExercises()
    {
        return (LinkedHashSet<String>) new LinkedHashSet<>(Arrays.asList(LegsEx));
    }*/
    public static String[] getWarmUp(int num)
    {
        return WarmUp[num];
    }

    public static LinkedHashSet<String> getChestExercisesByLevel(int level)
    {
        LinkedHashSet<String> Res= new LinkedHashSet<>();
        Res= (LinkedHashSet<String>) new LinkedHashSet<String>(Arrays.asList(ChestEx[level-1]));
        return Res;
    }
    public static LinkedHashSet<String> getEnduranceExercisesByLevel(int level)
    {
        LinkedHashSet<String> Res= new LinkedHashSet<>();
        Res= (LinkedHashSet<String>) new LinkedHashSet<String>(Arrays.asList(EnduranceEx[level-1]));
        return Res;
    }
    public static LinkedHashSet<String> getAbsExercisesByLevel(int level)
    {
        LinkedHashSet<String> Res= new LinkedHashSet<>();
        Res= (LinkedHashSet<String>) new LinkedHashSet<String>(Arrays.asList(AbsEx[level-1]));
        return Res;
    }
    public static LinkedHashSet<String> getCoreExercisesByLevel(int level)
    {
        LinkedHashSet<String> Res= new LinkedHashSet<>();
        Res= (LinkedHashSet<String>) new LinkedHashSet<String>(Arrays.asList(CoreEx[level-1]));
        return Res;
    }
    public static LinkedHashSet<String> getLegsExercisesByLevel(int level)
    {
        LinkedHashSet<String> Res= new LinkedHashSet<>();
        Res= (LinkedHashSet<String>) new LinkedHashSet<String>(Arrays.asList(LegsEx[level-1]));
        return Res;
    }


}
