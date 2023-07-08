package med.voll.api.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

        public Medico(DadosCadastroMedico dados) {
            this.nome = dados.nome();
            this.email = dados.email();
            this.setTelefone(dados.telefone());
            this.crm = dados.crm();
                    this.especialidade = dados.especialidade();
            this.endereco = new Endereco(dados.endereco());
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
}