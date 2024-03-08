package com.example.demo.entidad;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

/**
 * @author: Iván Naranjo Marín
 */

@Table(name = "Comentarios")
@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String contenido; 
    /**
     * @param contenido EL PARÁMETRO CONTENIDO GUARDA EL CONTENIDO QUE SE CONTIENE EN CADA COMENTARIO
     */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    /**
     * @param usuario SE GUARDA LA ID DEL USUARIO QUE REALIZA EL COMENTARIO
     */
    
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fechaCreacion; 
    /** 
     * @param fechaCreacion SE GUARDA LA FECHA EN LA QUE SE CREÓ EL COMENTARIO
     */
    
    @PrePersist
    protected void prePersist() {
        if (fechaCreacion == null) {
            fechaCreacion = LocalDateTime.now(); // Establece la fecha y hora actual
        }
    }

    // Getters y setters
    
    /**
     * 
     * @return DEVUELVE LA ID DEL USUARIO
     */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param id ID DEL USUARIO
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return DEVUELVE EL CONTENIDO COMO STRING
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * 
	 * @param contenido CONTENIDO QUE COMPRENDE EL COMENTARIO
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	/**
	 * 
	 * @return DEVUELVE EL USUARIO DESEADO
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * 
	 * @param usuario OBJETO USUARIO CON TODOS SUS ATRIBUTOS
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * 
	 * @return DEVUELVE LA FECHA DE CREACIÓN DEL COMENTARIO
	 */
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * 
	 * @param fechaCreacion FECHA CUANDO SE CREO EL COMENTARIO
	 */
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return Los atributos de la clase en forma de string
	 */
	@Override
	public String toString() {
		return "Comentario [id=" + id + ", contenido=" + contenido + ", usuario=" + usuario + ", fechaCreacion="
				+ fechaCreacion + "]";
	}
	

	

}