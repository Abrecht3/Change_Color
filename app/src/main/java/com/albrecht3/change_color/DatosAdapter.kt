package com.albrecht3.change_color

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class DatosAdapter(
    private val context: Context,
    private val layoutResourceId: Int,
    private val datos: Array<Datos>
) : ArrayAdapter<Datos>(context, layoutResourceId, datos) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var row = convertView
        val holder: DatosHolder

        if (row == null) {
            val inflater = (context as Activity).layoutInflater
            row = inflater.inflate(layoutResourceId, parent, false)

            holder = DatosHolder()
            holder.imagen = row.findViewById(R.id.imagen)
            holder.texto = row.findViewById(R.id.tv)

            row.tag = holder
        } else {
            holder = row.tag as DatosHolder
        }

        val dato = datos[position]
        holder.texto?.text = dato.name
        holder.imagen?.setImageResource(dato.icon)

        return row!!
    }

    internal class DatosHolder {
        var imagen: ImageView? = null
        var texto: TextView? = null
    }
}