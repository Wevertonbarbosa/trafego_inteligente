package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import services.UsuarioService;

import java.util.List;
import java.util.Map;

public class CadastroUsuariosSteps {
    UsuarioService usuarioService = new UsuarioService();

    @Dado("que eu tenha os seguintes dados do usuário:")
    public void queEuTenhaOsSeguintesDadosDoUsuário(List<Map<String, String>> rows) {
        for (Map<String, String> columns : rows) {
            usuarioService.setFields(columns.get("campo"), columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint {string} de usuários")
    public void euEnviarARequisiçãoParaOEndpointDeUsuários(String endPoint) {
        usuarioService.createPost(endPoint);
    }

    @Então("o status code da resposta deve ser {int}")
    public void oStatusCodeDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, usuarioService.response.statusCode());
    }
}
