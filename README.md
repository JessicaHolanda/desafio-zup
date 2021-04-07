teste 

<code>
@Entity
@Table
public class AplicacaoVacina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min =2, max =100)
	private String vacina;
	
	@ManyToOne
	@JsonIgnoreProperties("aplicacaoVacina")
	private Usuario usuario;
  </code>
  
  
  teste
