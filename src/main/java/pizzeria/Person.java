package pizzeria;

public class Person
{
	private String nom ;
	private String mot_de_passe ;
	private String token ;
	private int id ;
	private boolean admin ;

	public Person()
	{
		
	}
	
	public Person( String nom , String mdp , String token , int id , boolean is_admin )
	{
		this.nom = nom ;
		this.mot_de_passe = mdp ;
		this.token = token ;
		this.id = id ;
		this.admin = is_admin ;
	}
	
	public String toString()
	{
		return "personne[" + "nom : " + this.nom + ", mdp : " + this.mot_de_passe + ", token connexion : " + this.token + ", id : " + this.id + ", est admin : " + this.admin + " ]" ;
	}

	public String get_nom()
	{
		return this.nom ;
	}
	
	public void set_nom( String nom )
	{
		this.nom = nom ;
	}

	public String get_mot_de_passe()
	{
		return mot_de_passe ;
	}

	public void set_mot_de_passe( String mdp )
	{
		this.mot_de_passe = mdp ;
	}
	
	public String get_token()
	{
		return this.token ;
	}
	
	public void set_token( String token )
	{
		this.token = token ;
	}
	
	public int get_id()
	{
		return this.id ;
	}
	
	public void set_id( int id )
	{
		this.id = id ;
	}

	public boolean is_admin()
	{
		return admin ;
	}

	public void set_admin( boolean admin )
	{
		this.admin = admin ;
	}
}
