package valle.carlos.thecheezery

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class ProductosActvity2 : AppCompatActivity() {

    var hotDrinks= ArrayList<Product>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos_actvity2)

        agregaProductos()

        var listView: ListView= findViewById(R.id.lista2)as ListView

        var adaptador: ProductosActvity2.AdaptadorProductos = ProductosActvity2.AdaptadorProductos(this, hotDrinks)

        listView.adapter= adaptador

    }

    fun agregaProductos(){
        hotDrinks.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6.0))
        hotDrinks.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5.0))
        hotDrinks.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.0))
        hotDrinks.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6.0))
        hotDrinks.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.0))
        hotDrinks.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2.0))
    }

    private class AdaptadorProductos: BaseAdapter {
        var productos= ArrayList<Product>()
        var contexto: Context?= null

        constructor(contexto: Context, productos: ArrayList<Product>){
            this.productos= productos
            this.contexto= contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var prod= productos[p0]
            var inflador= LayoutInflater.from(contexto)
            var vista= inflador.inflate(R.layout.producto_view, null)

            var imagen= vista.findViewById(R.id.producto_img)as ImageView
            var nombre= vista.findViewById(R.id.producto_nombre)as TextView
            var desc= vista.findViewById(R.id.producto_ds)as TextView
            var precio= vista.findViewById(R.id.producto_precio)as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.descripcion)
            precio.setText("$${prod.price}")

            return vista
        }
    }
}