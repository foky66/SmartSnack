package hu.smart_snack.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountiesAndCities {
    private final HashMap<String, List<String>> countiesAndCities = new HashMap();

    {
        countiesAndCities.put("Pest", List.of("Abony","Albertirsa","Aszód","Biatorbágy","Budakalász","Budakeszi",
                "Budaörs","Cegléd","Dabas","Dunaharaszti","Dunakeszi","Dunavarsány","Fót","Göd","Gödöllő","Gyál","Gyömrő",
                "Halásztelek","Isaszeg","Kistarcsa","Maglód","Monor","Nagykáta","Nagykőrös","Nagymaros","Ócsa","Örkény",
                "Pécel","Pilis","Pilisvörösvár","Pomáz","Ráckeve","Százhalombatta","Szentendre","Szigethalom","Szigetszentmiklós",
                "Szob","Tápiószele","Tököl","Törökbálint","Tura","Üllő","Vác","Vecsés","Veresegyház","Visegrád","Zsámbék"));
        countiesAndCities.put("Komárom-Esztergom", List.of("Ács","Bábolna","Dorog","Esztergom","Kisbér","Komárom","Lábatlan","Nyergesújfalu","Oroszlány","Tata"));
        countiesAndCities.put("Győr-Moson-Sopron", List.of("Beled","Csorna","Fertőd","Fertőszentmiklós","Jánossomorja","Kapuvár","Mosonmagyaróvár","Pannonhalma","Tét"));
        countiesAndCities.put("Vas", List.of("Bük","Celldömölk","Csepreg","Körmend","Kőszeg","Őriszentpéter","Répcelak","Sárvár","Szentgotthárd","Vasvár","Vép"));
        countiesAndCities.put("Veszprém", List.of("Ajka","Badacsonytomaj","Balatonalmádi","Balatonfüred","Balatonfűzfő","Balatonkenese","Berhida","Devecser","Herend","Pápa","Sümeg","Tapolca","Várpalota","Zirc"));
        countiesAndCities.put("Budapest", List.of("I. kerület (Budavár)","II. kerület (-)","III. kerület (Óbuda-Békásmegyer)","IV. kerület (Újpest)",
                "V. kerület (Belváros-Lipótváros)","VI. kerület (Terézváros)","VII. kerület (Erzsébetváros)","VIII. kerület (Józsefváros)",
                "IX. kerület (Ferencváros) ","X. kerület (Kőbánya)","XI. kerület (Újbuda)","XII. kerület (Hegyvidék)","XIII. kerület (-)",
                "XIV. kerület (Zugló)","XV. kerület (Rákospalota-Pestújhely-Újpalota)","XVI. kerület (-)","XVII. kerület (Rákosmente)",
                "XVIII. kerület (Pestszentlőrinc-Pestszentimre)","XIX. kerület (Kispest)","XX. kerület (Pesterzsébet)","XXI. kerület (Csepel)",
                "XXII. kerület (Budafok-Tétény)","XXIII. kerület (Soroksár)"));
    }

    public List<String> getCounties(){
      return new ArrayList<>(countiesAndCities.keySet());
    }

    public List<String> getCities(String county){
         return countiesAndCities.get(county);
    }

}
