package com.institutomisionero.IM.ui.coritario;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import com.institutomisionero.IM.PDF;
import com.institutomisionero.IM.R;

import java.util.ArrayList;

public class CoritarioFragment extends Fragment {

    ListView listaDatos;
    ArrayList<Datos> Lista = new ArrayList<>();

    Adaptador miadaptador;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.coritario_fragment, container, false);

        listaDatos = view.findViewById(R.id.lstDatos);

        //AGREGAR TEMAIKENES
        Lista.add(new Datos(1, "A ti, Jesús"));
        Lista.add(new Datos(2, "Abre mis ojos"));
        Lista.add(new Datos(3, "Abre mis ojos, Señor"));
        Lista.add(new Datos(4, "Agnus dei"));
        Lista.add(new Datos(5, "Alabaré"));
        Lista.add(new Datos(6, "Al encuentro de Jesús"));
        Lista.add(new Datos(7, "Alma misionera"));
        Lista.add(new Datos(8, "Alto, escúchame"));
        Lista.add(new Datos(9, "Alzaré mis ojos"));
        Lista.add(new Datos(10, "Amor, amor amor, amor"));
        Lista.add(new Datos(11, "Amigo, ¿amas a Cristo?"));
        Lista.add(new Datos(12, "Arco iris"));
        Lista.add(new Datos(13, "Atardece"));
        Lista.add(new Datos(14, "Avancemos"));
        Lista.add(new Datos(15, "Blanqueados"));
        Lista.add(new Datos(16, "Brilla en mi"));
        Lista.add(new Datos(17, "Brilla, Jesús"));
        Lista.add(new Datos(18, "Brillar por ti"));                     //doble 17
        Lista.add(new Datos(19, "Buscad primero"));                     //18 a 27 (i+1)
        Lista.add(new Datos(20, "Búscale hoy"));
        Lista.add(new Datos(21, "Cada día de mañana"));
        Lista.add(new Datos(22, "Cantad a Dios"));
        Lista.add(new Datos(23, "Cantaré de tu amor por siempre"));
        Lista.add(new Datos(24, "Canto de alegría"));
        Lista.add(new Datos(25, "Cerca de Jesús"));
        Lista.add(new Datos(26, "Como el ciervo"));
        Lista.add(new Datos(27, "Como las olas"));
        Lista.add(new Datos(28, "Como no cantar"));
        Lista.add(new Datos(29, "Conmigo estás"));                      //doble 28
        Lista.add(new Datos(30, "Cristo joven"));                       //29 a 39 (i+2)
        Lista.add(new Datos(31, "Cual la quietud de un arroyo"));
        Lista.add(new Datos(32, "Cuán grande eres, Dios"));
        Lista.add(new Datos(33, "Cuando Cristo vino a mi corazón"));
        Lista.add(new Datos(34, "Cuando el pueblo de Dios ora"));
        Lista.add(new Datos(35, "Cuando miro los claros cielos"));
        Lista.add(new Datos(36, "Da una sonrisa"));
        Lista.add(new Datos(37, "Dad gloria al Señor"));
        Lista.add(new Datos(38, "Dame un nuevo corazón"));
        Lista.add(new Datos(39, "De gloria en gloria"));
        Lista.add(new Datos(40, "Demos gracias al Señor"));
        Lista.add(new Datos(41, "Descansar"));                          //doble 40
        Lista.add(new Datos(42, "Después del rio"));                    //41 a 60 (i+3)
        Lista.add(new Datos(43, "Diez mil razones"));
        Lista.add(new Datos(44, "Digno eres"));
        Lista.add(new Datos(45, "Digno es el Señor"));
        Lista.add(new Datos(46, "Dios, alzamos hoy tu nombre"));
        Lista.add(new Datos(47, "Dios es nuestro amparo y fortaleza"));
        Lista.add(new Datos(48, "Él es Jehová el Señor"));
        Lista.add(new Datos(49, "El mejor lugar del mundo"));
        Lista.add(new Datos(50, "En mi caminar"));
        Lista.add(new Datos(51, "En momentos así"));
        Lista.add(new Datos(52, "Enciende una luz"));
        Lista.add(new Datos(53, "Eres mi refugio"));
        Lista.add(new Datos(54, "Eres mi respirar"));
        Lista.add(new Datos(55, "Eres mi todo"));
        Lista.add(new Datos(56, "Eres tú"));
        Lista.add(new Datos(57, "Es exaltado"));
        Lista.add(new Datos(58, "Espíritu Santo"));
        Lista.add(new Datos(59, "Éste es mi deseo"));
        Lista.add(new Datos(60, "Estoy en paz"));
        Lista.add(new Datos(61, "Fe en fuego"));
        Lista.add(new Datos(62, "Fiel en toda prueba"));                //doble 61
        Lista.add(new Datos(63, "Fija tus ojos en Cristo"));            //62 a 67 (i+4)
        Lista.add(new Datos(64, "Grande es Jehová"));
        Lista.add(new Datos(65, "Hablar con Dios"));
        Lista.add(new Datos(66, "Hay mil millones de estrellas"));
        Lista.add(new Datos(67, "Hay una iglesia en el bosque"));
        Lista.add(new Datos(68, "He decidido seguir a Cristo"));
        Lista.add(new Datos(69, "Hermoso nombre"));                     //doble 68
        Lista.add(new Datos(70, "Hoy aquí"));                           //69 a ... (i+5)
        Lista.add(new Datos(71, "Jesús es mi vida"));
        Lista.add(new Datos(72, "Jesús mi guía es"));
        Lista.add(new Datos(73, "Jesús te ama"));
        Lista.add(new Datos(74, "Jesús, tú eres mi alegría"));
        Lista.add(new Datos(75, "La alegría"));
        Lista.add(new Datos(76, "La mañana gloriosa"));
        Lista.add(new Datos(77, "La sangre de Cristo Jesús"));
        Lista.add(new Datos(78, "Lado a lado"));
        Lista.add(new Datos(79, "Llévame a la cruz"));
        Lista.add(new Datos(80, "Majestuoso Dios"));
        Lista.add(new Datos(81, "Maranata"));
        Lista.add(new Datos(82, "Maravillas"));
        Lista.add(new Datos(83, "Maravilloso Dios"));
        Lista.add(new Datos(84, "Me siento bien"));
        Lista.add(new Datos(85, "Mensajero"));
        Lista.add(new Datos(86, "Mi Cristo me salva"));
        Lista.add(new Datos(87, "Mi Dios puede salvar"));
        Lista.add(new Datos(88, "Mi Dios, supremo Rey"));
        Lista.add(new Datos(89, "Mi reino"));
        Lista.add(new Datos(90, "Mira qué linda es la vida"));
        Lista.add(new Datos(91, "Mirad cuál amor"));
        Lista.add(new Datos(92, "Necesario"));
        Lista.add(new Datos(93, "No existe bien para mí"));
        Lista.add(new Datos(94, "No importa de dónde tú vengas"));
        Lista.add(new Datos(95, "No me olvidé de ti"));
        Lista.add(new Datos(96, "Nunca estés desanimado"));
        Lista.add(new Datos(97, "Oba oba"));
        Lista.add(new Datos(98, "Océanos"));
        Lista.add(new Datos(99, "Oh, amor de Dios"));
        Lista.add(new Datos(100, "Padre de amor"));
        Lista.add(new Datos(101, "Padre, yo te adoro"));
        Lista.add(new Datos(102, "Paso a paso"));
        Lista.add(new Datos(103, "Paz en la tormenta"));
        Lista.add(new Datos(104, "Pescador"));
        Lista.add(new Datos(105, "Poema de salvación"));
        Lista.add(new Datos(106, "Pon tus manos en las manos del Señor"));
        Lista.add(new Datos(107, "Por encima de todo"));
        Lista.add(new Datos(108, "Por eso alabamos"));
        Lista.add(new Datos(109, "Por eso le amo"));
        Lista.add(new Datos(110, "Por tu gracia y amor"));
        Lista.add(new Datos(111, "Príncipe de paz"));
        Lista.add(new Datos(112, "Promesa"));
        Lista.add(new Datos(113, "Queremos ver"));
        Lista.add(new Datos(114, "Queremos ver a Cristo regresar"));
        Lista.add(new Datos(115, "Quién dices que soy"));
        Lista.add(new Datos(116, "Quiero cantar una linda canción"));
        Lista.add(new Datos(117, "Rendid a Yahvé"));
        Lista.add(new Datos(118, "Renuévame"));
        Lista.add(new Datos(119, "Restaura"));
        Lista.add(new Datos(120, "Salmo 1"));
        Lista.add(new Datos(121, "Santo es el Señor"));
        Lista.add(new Datos(122, "Santo Espíritu"));
        Lista.add(new Datos(123, "Sé una luz"));
        Lista.add(new Datos(124, "Sentado estaba en mi barca"));
        Lista.add(new Datos(125, "Señor, aviva tu obra en mí"));
        Lista.add(new Datos(126, "Señor, tu gracia"));
        Lista.add(new Datos(127, "Sólo en ti"));
        Lista.add(new Datos(128, "Somos la luz"));
        Lista.add(new Datos(129, "Somos su voz"));
        Lista.add(new Datos(130, "Tal como soy"));
        Lista.add(new Datos(131, "Te exaltaré"));
        Lista.add(new Datos(132, "Tengo paz como un río"));
        Lista.add(new Datos(133, "Tomados de la mano"));
        Lista.add(new Datos(134, "Todopoderoso"));
        Lista.add(new Datos(135, "Tu amor me inundó"));
        Lista.add(new Datos(136, "Tu amor por mí"));
        Lista.add(new Datos(137, "Tu poder"));
        Lista.add(new Datos(138, "Tu santo nombre"));
        Lista.add(new Datos(139, "Tuyo soy"));
        Lista.add(new Datos(140, "Un millón"));
        Lista.add(new Datos(141, "Vamos a adorar"));
        Lista.add(new Datos(142, "Vaso de honra"));
        Lista.add(new Datos(143, "Ven a la cruz"));
        Lista.add(new Datos(144, "Ven, es tiempo de adorarle"));
        Lista.add(new Datos(145, "Vengo a adorarte"));
        Lista.add(new Datos(146, "Veré a Jesús"));
        Lista.add(new Datos(147, "Voy caminando"));
        Lista.add(new Datos(148, "Yo soy feliz"));
        Lista.add(new Datos(149, "Yo tengo esperanza"));                //doble 148
        Lista.add(new Datos(150, "Yo voy"));                            //149 a ... (i+6)


        //ADAPTADOR
        miadaptador = new Adaptador(getActivity().getApplicationContext(), Lista);
        listaDatos.setAdapter(miadaptador);

        //PDF
        listaDatos.setOnItemClickListener((parent, view1, position, id) -> {

            int pos = Lista.indexOf(miadaptador.getItem(position));

            Intent paso = new Intent(getActivity().getApplicationContext(), PDF.class);
            paso.putExtra("id", pos);
            startActivity(paso);
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        //Agregar items al action bar
        inflater.inflate(R.menu.search, menu);
        MenuItem menuItem = menu.findItem((R.id.search_view));
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                miadaptador.getFilter().filter(newText);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.search_view){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
