import java.util.*;

public class Tienda {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String mensaje=" ";
		int [] indices=new int [5];
		String [] datos=new String[6];  
		ArrayList<Producto> productos=new ArrayList<Producto>();
		while(mensaje.charAt(0)!='3') {
			mensaje=scan.nextLine();
			if (mensaje.charAt(0)=='1') {
				int j=0;
				for (int i=0;i<mensaje.length();i++){
					if (mensaje.charAt(i)=='&') {
						indices[j]=i;
						j+=1;
					}
				}
				int inicio=0,fin=1;
				for (int i=0;i<4;i++) {
					datos[i]= mensaje.substring(indices[inicio]+1, indices[fin]);
					inicio+=1;
					fin+=1;
				}
				datos[4]=mensaje.substring(indices[4]+1);
				if (datos[0].equalsIgnoreCase("Refrigerado")) {
					productos.add(new Refrigerado(datos[1], datos[2], datos[3], datos[4]));
				}else {
					productos.add(new NoRefrigerado(datos[1], datos[2], datos[3], datos[4]));
				}
				
			}else if(mensaje.charAt(0)=='2') {
				System.out.println("***Inventario de productos***");
				for (Producto p: productos) {
					System.out.println(p.dame_valores());
				}
			}
		}
		scan.close();
	}
}
class Producto {
	private String cantidad;
	private String costo;
	private String codigo;	
	public Producto(String cantidad,String costo,String codigo) {
		this.cantidad=cantidad;
		this.costo=costo;
		this.codigo=codigo;
	}
	public String dame_valores() {
		return "";
	}
	public String dame_cantidad() {
		return cantidad;
	}
	public String dame_costo() {
		return costo;
	}
	public String dame_codigo() {
		return codigo;
	}
}
class NoRefrigerado extends Producto{
	private String pais;
	public NoRefrigerado (String cantidad,String costo,String codigo,String pais) {
		super(cantidad,costo,codigo);
		this.pais=pais;
	}
	public String dame_valores() {
		String cantidad=super.dame_cantidad();
		String costo=super.dame_costo();
		String codigo=super.dame_codigo();
		return "\tProducto Norefrigerado - Código: "+codigo+"\n\tcosto: "+costo+" pesos"+"\n\tcantidad: "+cantidad+"\n\tpaís: "+pais;
	}
}

class Refrigerado extends Producto{
	private String temp;
	public Refrigerado (String cantidad,String costo,String codigo,String temp) {
		super(cantidad,costo,codigo);
		this.temp=temp;
	}
	public String dame_valores() {
		String cantidad=super.dame_cantidad();
		String costo=super.dame_costo();
		String codigo=super.dame_codigo();
		return "\tProducto Refrigerado - Código: "+codigo+"\n\tcosto: "+costo+" pesos"+"\n\tcantidad: "+cantidad+"\n\ttemperatuta: "+temp+" grados centígrados";
	}
}