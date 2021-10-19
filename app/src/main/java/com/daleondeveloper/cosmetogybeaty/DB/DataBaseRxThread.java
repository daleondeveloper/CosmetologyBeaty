package com.daleondeveloper.cosmetogybeaty.DB;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daleondeveloper.cosmetogybeaty.DB.Entity.Procedure;
import com.daleondeveloper.cosmetogybeaty.MakeAppointmentActivity;
import com.daleondeveloper.cosmetogybeaty.ProcedureInfoActivity;
import com.daleondeveloper.cosmetogybeaty.R;
import com.daleondeveloper.cosmetogybeaty.adapter.ProcedureAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DataBaseRxThread {

   private final CosmetologyDataBase dataBase;

    public DataBaseRxThread(CosmetologyDataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void insertStartElements(){
        List<Procedure> procedures = new ArrayList<>();
        procedures.add(new Procedure("Біоревіталізація",                        "Биоревитализация – эффективная методика для профилактики и коррекции возрастных изменений. Задача процедуры заключается в том, чтобы воздействовать на основную причину старения эпидермиса – потерю водного баланса и способности удерживать влагу. Препараты насыщают кожу гиалуроновой кислотой, которая увлажняет ее и восстанавливает водный баланс. В результате морщинки и складки разглаживаются, процессы старения замедляются, а признаки увядания исчезают.\n",
                "БИОРЕВИТАЛИЗАЦИЯ ЧТО ЭТО ТАКОЕ?\n\n" +
                        "Биоревитализация – эффективная методика для профилактики и коррекции возрастных изменений. Задача процедуры заключается в том, чтобы воздействовать на основную причину старения эпидермиса – потерю водного баланса и способности удерживать влагу. Препараты насыщают кожу гиалуроновой кислотой, которая увлажняет ее и восстанавливает водный баланс. В результате морщинки и складки разглаживаются, процессы старения замедляются, а признаки увядания исчезают.\n" +
                        "\n\n" +
                        "*Преимущества\n\n" +
                        "*Как проходит лечение\n\n" +
                        "*Показания\n\n" +
                        "*Противопоказания\n\n" +
                        "*Длительность эффекта\n\n" +
                        "*Уход за кожей после\n\n" +
                        "*Сколько стоит?\n\n" +
                        "*Видео\n\n" +
                        "        \n\n\n" +
                        "        ПРЕИМУЩЕСТВА, КОТОРЫМИ ОБЛАДАЕТ БИОРЕВИТАЛИЗАЦИЯ:\n" +
                        "        \n\n" +
                        "*Естественное омолаживание. Концентрация эластина и коллагена в клетках с возрастом уменьшается, кожа становится сухой и дряблой. Попадая в ткани, действующий компонент препаратов – гиалуроновая кислота – запускает генерацию этих веществ, питает и увлажняет кожу естественным образом.\n" +
                        "\n" +
                        "        *Быстрый результат. Видимый эффект проявляется практически сразу - он будет заметен уже через 1-2 сеанса.\n" +
                        "\n" +
                        "        *Продолжительный эффект. Процедура позволяет надолго забыть о морщинах, дряблом сухом лице. Результат сохраняется до полугода, а при правильных условиях кожа остается эластичной и свежей несколько лет.\n" +
                        "Биоревитазация\n" +
                        "\n" +
                        "        КАК ПРОХОДИТ БИОРЕВИТАЛИЗАЦИЯ\n" +
                        "Биоревитализация гиалуроновой кислотой – курс инъекционных процедур, во время которых тонкие, атравматичные иглы проникают точно в проблемную зону на определенную глубину в районе лица, рук, век, зоны декольте. Образующиеся при этом проколы дополнительно стимулируют иммунитет, запуская процессы регенерации. Операция практически безболезненна, зона заранее обрабатывается анестезирующим препаратом.\n" +
                        "\n" +
                        "Один такой сеанс длится 45-60 минут, повторяется 4-6 раз в зависимости от курса, назначенного врачом. Полный курс следует выполнять хотя бы раз в полгода, а в перерывах между ними проводить специальные поддерживающие процедуры, такие как массаж и другие косметологические виды ухода за кожей, которые пропишет врач.\n" +
                        "\n" +
                        "Цена на биоревитализацию формируется в зависимости от выбранного препарата. Препарат определяет доктор на очной консультации по состоянию кожи пациента, а также в зависимости от желаемого пациентом эффекта.\n" +
                        "\n" +
                        "        \n" +
                        "ПОКАЗАНИЯ\n" +
                        "В 25 лет выработка клетками собственных полезных веществ начинает протекать менее активно, поэтому стоит задуматься о профилактике возрастных изменений. Основные причины для проведения процедуры биоревитализации:\n" +
                        "\\n\n" +
                        "*Возникновение морщин или их профилактика;\\n\n" +
                        "*Возрастные изменения: дряблость, сухость кожи;\\n\n" +
                        "*Изменение цвета лица: потускнение, пигментные пятна, круги под глазами;\\n\n" +
                        "*Расширенные поры, повышенная активность сальных желез;\\n\n" +
                        "*Восстановление клеток после пластических операций, шлифовки, пиллингов\n" +
                        "процедура биоревитализации\\n\\n\\n\n" +
                        "\n" +
                        "        <b>ПРОТИВОПОКАЗАНИЯ</b>\\n\n" +
                        "Кому нельзя делать биоревитализацию? Перечень противопоказаний стандартен: это заболевания крови и сосудов, сахарный диабет, онкология, туберкулез и т.д.\n" +
                        "\\n\n" +
                        "Препятствием станут и индивидуальная непереносимость лазера и гиалуроновой кислоты. Нельзя ставить инъекции беременным и в период лактации. Во время вирусной или кишечной инфекций уколы тоже запрещены.\n" +
                        "\\n\n" +
                        "Возраст – относительное противопоказание к процедуре. До 25 лет уколы делать не стоит. Исключение – если на лице очень сухая кожа, тогда можно помочь восстановить гидробаланс чуть раньше, в 20-25 лет.\n" +
                        "\\n\n" +
                        "Часто спрашивают, можно ли проводить процедуру гиалуроновой кислотой, если на лице есть родинки. Прямо в них вводить иглу, конечно, нельзя. Но сами по себе родимые пятна не являются противопоказанием, инъекции ставят между ними.\n" +
                        "\n" +
                        "\\n\\n\n" +
                        "        <b>ДЛИТЕЛЬНОСТЬ ЭФФЕКТА БИОРЕВИТАЛИЗАЦИИ</b>\\n\n" +
                        "Действие гиалуроновой кислоты очевидно уже после второй процедуры, а окончательный эффект достигается – после четвертой и длится примерно 6 месяцев. Кожа начинает сиять, становится гораздо более  эластичной. Так работают вводимые препараты: создается гидрорезерв, который увлажняет и нормализует дерму.\n" +
                        "\\n\n" +
                        "Иногда может смутить, что после первых инъекций на лице ощущается сухость, особенно если процедуры проводятся в отопительный период. Это нормально и скоро сухость исчезнет. Также важно знать, что первые несколько дней на местах уколов могут ощущаться бугорки-папулы. Они исчезнут через 1-3 дня.\n" +
                        "\\n\n" +
                        "Косметолог, оценив состояние кожи, предложит оптимальный для клиента график визитов в клинику. Чаще всего биоревитализация выполняется курсом из 4-6 процедур с двухнедельным интервалом между ними. Между курсами необходимы поддерживающие процедуры, их назначит косметолог.\n" +
                        "\\n\\n\n" +
                        "        <b>УХОД ЗА КОЖЕЙ ПОСЛЕ БИОРЕВИТАЛИЗАЦИИ</b>\\n\n" +
                        "Процедура не требует специальной подготовки. А вот после нее несколько дней надо воздержаться от того, что может травмировать обработанное лицо. Это массаж, занятия активным спортом, баня и сауна. От макияжа на пару дней придется отказаться. Лучше не трогать лицо руками - так процесс заживления пройдет быстрее, а риск инфицирования снизится.\n" +
                        "\\n\n" +
                        "Обязательно обсудите с косметологом, какими средствами можно пользоваться после биоревитализации. В некоторых случаях подойдет привычный уход за кожей, а некоторым дамам врач посоветует специальные средства.</string>\n" +
                        "\\n",
                "2Ny7AlxPt4k","biorevitalizatiya",1500,60,true
        ));
        procedures.add(new Procedure("Мезотерапія лиця",
                "Купероз – достаточно распространенное как среди женщин, так и мужчин, сосудистое нарушение. В дерматологии купероз принято называть телеангиэктазиями. Внешне он проявляется выраженным сосудистым рисунком на коже лица (более заметная локализация).",
                "Купероз – достаточно распространенное как среди женщин, так и мужчин, сосудистое нарушение. В дерматологии купероз принято называть телеангиэктазиями. Внешне он проявляется выраженным сосудистым рисунком на коже лица (более заметная локализация).",
                "FazkfIG4dvs","mezoteraphy",2000,30,true
        ));
        procedures.add(new Procedure("Пілінг",
                "Пілінг – косметологічна процедура, що передбачає видалення верхніх ороговілих шарів шкіри і активацію процесів активної регенерації клітин. Слово «пілінг» походить від англійського дієслова to peel «зчищати», «знімати», що точно описує механізми впливу процедури.\",",
                "Пілінг – косметологічна процедура, що передбачає видалення верхніх ороговілих шарів шкіри і активацію процесів активної регенерації клітин. Слово «пілінг» походить від англійського дієслова to peel «зчищати», «знімати», що точно описує механізми впливу процедури.\",",
                "hY0KJs0DOB0","piling_avatar",400,90,true
        ));
        dataBase.procedureDao().insertAll(procedures).subscribeOn(Schedulers.io()).subscribe(new Action() {
            @Override
            public void run() throws Exception {
                // success
            }
        }, new Consumer< Throwable >() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                // error
            }
        });
    }
    public void setCardViewProcedures(final Activity activity, final int recycleView){
        dataBase.procedureDao().getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Procedure>>() {
                    @Override
                    public void accept(List<Procedure> procedures) throws Exception {
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity,RecyclerView.VERTICAL,false);
                        RecyclerView courseRecycle ;
                        ProcedureAdapter procedureAdapter;
                        courseRecycle   = activity.findViewById(recycleView);
                        courseRecycle.setLayoutManager(layoutManager);

                        procedureAdapter = new ProcedureAdapter(activity,procedures);
                        courseRecycle.setAdapter(procedureAdapter);
                    }
                });
    }
    public void setSpinnerMakeAppointment(final Activity activity, final int spinnerId){
        dataBase.procedureDao().getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Procedure>>() {
                    @Override
                    public void accept(List<Procedure> procedures) throws Exception {
                        Spinner spinner = (Spinner)activity.findViewById(spinnerId);
                        List<String> s = new ArrayList<>();
                        for(Procedure procedure : procedures){
                            s.add(procedure.getName());
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,  android.R.layout.simple_spinner_item, s);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(adapter);
                    }
                });
    }
    public void setMakeAppointmentCostAndDuration(final MakeAppointmentActivity activity, final String procedureName){
        dataBase.procedureDao().getProcedureByName(procedureName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Procedure>() {
                    @Override
                    public void accept(Procedure procedure) throws Exception {
                        activity.setOnTextView(procedure.getCost(),procedure.getDuration());
                    }
                });
    }
    public void setInfoActivityDate(final ProcedureInfoActivity activity, final String procedureName){
        dataBase.procedureDao().getProcedureByName(procedureName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Procedure>() {
                    @Override
                    public void accept(Procedure procedure) throws Exception {
                        activity.updateActivityDate(procedure);
                    }
                });
    }
}
