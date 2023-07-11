package med.voll.api.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name= "medicos")
@Entity(name= "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico{
        
		    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String email;
        private String telefone;
        private String crm;
        
        @Enumerated(EnumType.STRING)
        private Especialidade especialidade;
        
        @Embedded
        private Endereco endereco;
        
        private Boolean ativo;

        public Medico(DadosCadastroMedico dados) {
            this.setAtivo(true);
            this.nome = dados.nome();
            this.email = dados.email();
            this.telefone = dados.telefone();
            this.crm = dados.crm();
            this.especialidade = dados.especialidade();
            this.endereco = new Endereco(dados.endereco());
        }
        
       public Medico() {
       }
        
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCrm() {
			return crm;
		}

		public void setCrm(String crm) {
			this.crm = crm;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		
		public Especialidade getEspecialidade() {
			return especialidade;
		}

		public Long getId() {
			return id;
		}

		public void atualizarInformacoes(@Valid DadosAtualizacaoMedico dados) {
			if(dados.nome() != null) {
				this.nome = dados.nome();
			}
			
			if (dados.telefone() != null) {
				this.telefone = dados.telefone();
			}
			
			if (dados.endereco() != null) {
	            this.endereco.atualizarInformacoes(dados.endereco());
	        }
		}

		public void excluir() {
			this.setAtivo(false);	
		}

		public Boolean getAtivo() {
			return ativo;
		}

		public void setAtivo(Boolean ativo) {
			this.ativo = ativo;
		}
}