/**
 * @version 27/09/2007 <BR>
 * @author Setpoint Inform�tica Ltda./Reginado Garcia Heua <BR>
 *
 * Projeto: Freedom <BR>
 *  
 * Pacote: org.freedom.modulos.std <BR>
 * Classe: @(#)FRCpProd.java <BR>
 * 
 * Este programa � licenciado de acordo com a LPG-PC (Licen�a P�blica Geral para Programas de Computador), <BR>
 * vers�o 2.1.0 ou qualquer vers�o posterior. <BR>
 * A LPG-PC deve acompanhar todas PUBLICA��ES, DISTRIBUI��ES e REPRODU��ES deste Programa. <BR>
 * Caso uma c�pia da LPG-PC n�o esteja dispon�vel junto com este Programa, voc� pode contatar <BR>
 * o LICENCIADOR ou ent�o pegar uma c�pia em: <BR>
 * Licen�a: http://www.lpg.adv.br/licencas/lpgpc.rtf <BR>
 * Para poder USAR, PUBLICAR, DISTRIBUIR, REPRODUZIR ou ALTERAR este Programa � preciso estar <BR>
 * de acordo com os termos da LPG-PC <BR> <BR>
 *
 * Coment�rios sobre a classe...
 * 
 */
package org.freedom.modulos.std;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;

import net.sf.jasperreports.engine.JasperPrintManager;

import org.freedom.componentes.GuardaCampo;
import org.freedom.componentes.ImprimeOS;
import org.freedom.componentes.JLabelPad;
import org.freedom.componentes.JRadioGroup;
import org.freedom.componentes.JTextFieldFK;
import org.freedom.componentes.JTextFieldPad;
import org.freedom.componentes.ListaCampos;
import org.freedom.funcoes.Funcoes;
import org.freedom.telas.Aplicativo;
import org.freedom.telas.FPrinterJob;
import org.freedom.telas.FRelatorio;


public class FRCpProd extends FRelatorio {

	private static final long serialVersionUID = 1L;
	
	private JTextFieldPad txtCodMarca = new JTextFieldPad(JTextFieldPad.TP_STRING,6,0);

	private JTextFieldFK txtDescMarca = new JTextFieldFK(JTextFieldPad.TP_STRING,40,0);
	
	private JTextFieldPad txtCodGrupo = new JTextFieldPad(JTextFieldPad.TP_STRING,14,0);
	
	private JTextFieldFK txtDescGrupo = new JTextFieldFK(JTextFieldPad.TP_STRING,40,0); 
	
	private JTextFieldPad txtCodProd = new JTextFieldPad( JTextFieldPad.TP_INTEGER, 10, 0 );

	private JTextFieldFK txtDescProd = new JTextFieldFK( JTextFieldPad.TP_STRING, 50, 0 );
	
	private ListaCampos lcProduto = new ListaCampos( this );
	
	private ListaCampos lcGrupo = new ListaCampos(this);
	
	private ListaCampos lcMarca = new ListaCampos(this);
	
	private JRadioGroup<?, ?> rgOrdem = null;
	
	private Vector<String> vLabs = new Vector<String>();
	
	private Vector<String> vVals = new Vector<String>();
	
	private JRadioGroup<?, ?> rgTipo = null;
	
	private Vector<String> vLabs1 = new Vector<String>();
	
	private Vector<String> vVals1 = new Vector<String>();
	
	public FRCpProd(){
		
		setTitulo("�ltimas compras/produto");
		setAtribos(50, 50, 345, 330);
		
		montaTela();
		montaListaCampos();
		
	}
	
	public void montaTela(){
		
		vLabs.addElement("C�digo");
	    vLabs.addElement("Descri��o");
	    vVals.addElement("P.CODPROD");
	    vVals.addElement("P.DESCPROD");
	    
	    rgOrdem = new JRadioGroup<String, String>(1,2,vLabs,vVals);
	    rgOrdem.setVlrString("P.CODPROD");
	    
	    vLabs1.addElement("Texto");
	    vLabs1.addElement("Grafico");
	    vVals1.addElement("T");
	    vVals1.addElement("G");
	    
	    rgTipo = new JRadioGroup<String, String>(1,2,vLabs1,vVals1);
	    rgOrdem.setVlrString("T");
		
		adic( new JLabelPad("C�d.Prod"), 7, 10, 70, 20 );
		adic( txtCodProd, 7, 30, 70, 20 );
		adic( new JLabelPad("Descri��o do produto"), 80, 10, 170, 20 );
		adic( txtDescProd, 80, 30, 225, 20 );
		adic( new JLabelPad("C�d.Grupo"), 7, 50, 70, 20 );
		adic( txtCodGrupo, 7, 70, 70, 20 );
		adic( new JLabelPad("Descri��o do grupo"), 80, 50, 170, 20 ); 
		adic( txtDescGrupo, 80, 70, 225, 20 );
		adic( new JLabelPad("C�d.Marca"), 7, 90, 100, 20 );
		adic( txtCodMarca, 7, 110, 70, 20 );
		adic( new JLabelPad("Descri��o da marca"), 80, 90, 200, 20 );
		adic( txtDescMarca, 80, 110, 225, 20 );
		
		adic( new JLabelPad("Ordenar por:"), 7, 135, 80, 20 );
		adic( rgOrdem, 7, 155, 300, 35 ); 
		
		adic( new JLabelPad("Tipo:"), 7, 190, 80, 20 );
		adic( rgTipo, 7, 210, 300, 35 );
	}
	
	public void montaListaCampos(){
		
		/**********
		 *  Grupo *
		 **********/
		lcGrupo.add(new GuardaCampo( txtCodGrupo, "CodGrup", "C�d.grupo", ListaCampos.DB_PK, false));
		lcGrupo.add(new GuardaCampo( txtDescGrupo, "DescGrup", "Descri��o do grupo", ListaCampos.DB_SI, false));
		lcGrupo.montaSql(false, "GRUPO", "EQ");
		lcGrupo.setReadOnly(true);
		txtCodGrupo.setTabelaExterna(lcGrupo);
		txtCodGrupo.setFK(true);
		txtCodGrupo.setNomeCampo("CodGrup");
		
		/***********
		 *  Marca *
		 ***********/
		lcMarca.add(new GuardaCampo( txtCodMarca, "CodMarca", "C�d.marca", ListaCampos.DB_PK, false));
		lcMarca.add(new GuardaCampo( txtDescMarca, "DescMarca", "Descri��o da marca", ListaCampos.DB_SI, false));
		txtCodMarca.setTabelaExterna(lcMarca);
		txtCodMarca.setNomeCampo("CodMarca");
		txtCodMarca.setFK(true);
		lcMarca.setReadOnly(true);
		lcMarca.montaSql(false, "MARCA", "EQ");
		
		/***********
		 * Produto *
		 ***********/
		lcProduto.add( new GuardaCampo( txtCodProd, "CodProd", "C�d.produto", ListaCampos.DB_PK, false ) );
		lcProduto.add( new GuardaCampo( txtDescProd, "DescProd", "Descri��o do produto", ListaCampos.DB_SI, false ) );
		txtCodProd.setTabelaExterna( lcProduto );
		txtCodProd.setNomeCampo( "CodProd" );
		txtCodProd.setFK( true );
		lcProduto.setReadOnly( true );
		lcProduto.montaSql( false, "PRODUTO", "EQ" );
		
	}
	
	@ Override
	public void imprimir( boolean bVisualizar ) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuilder sSQL = new StringBuilder();
		StringBuilder sFiltro = new StringBuilder();
		StringBuilder sCab = new StringBuilder();
		
		if ( txtCodGrupo.getVlrString() != null && txtCodGrupo.getVlrString().trim().length()>0 ) {
			
			sFiltro.append( "AND P.CODGRUP='"+txtCodGrupo.getVlrString()+"'" );
			sCab.append( "Grupo: "+ txtDescGrupo.getVlrString() );

		}
		
		if ( txtCodMarca.getVlrString() != null && txtCodMarca.getVlrString().trim().length()>0 ) {
		
			sFiltro.append( "AND P.CODMARCA='"+txtCodMarca.getVlrString()+"'" );
			sCab.append( "Marca: "+ txtDescMarca.getVlrString() );
			
		}
		
		if( txtCodProd.getVlrString() != null && txtCodProd.getVlrString().trim().length()>0  ){
			
			sFiltro.append( "AND P.CODPROD='"+txtCodProd.getVlrString()+"'" );
			sCab.append( "Produto: "+ txtDescProd.getVlrString() );
		}
		
			
		sSQL.append( "SELECT P.CODPROD, P.REFPROD, P.DESCPROD, P.CODUNID,");
		sSQL.append( "IT.VLRPRODITCOMPRA, IT.VLRIPIITCOMPRA," );
		sSQL.append( "(IT.VLRPRODITCOMPRA+IT.VLRIPIITCOMPRA) VLRSUBTOTAL,");
		sSQL.append( "IT.VLRLIQITCOMPRA, C.DTEMITCOMPRA, C.DOCCOMPRA,");
		sSQL.append( "(IT.VLRIPIITCOMPRA/ (CASE WHEN IT.QTDITCOMPRA IS NULL OR IT.QTDITCOMPRA=0 THEN 1 " ); // IPI 
		sSQL.append( "ELSE IT.QTDITCOMPRA END )) IPIITCOMPRA, " );
		sSQL.append( "(IT.VLRFRETEITCOMPRA/ (CASE WHEN IT.QTDITCOMPRA IS NULL OR IT.CODITCOMPRA=0 THEN 1 " );// FRETE
		sSQL.append( "ELSE IT.QTDITCOMPRA END )) FRETEITCOMPRA, " );
		sSQL.append( "(IT.VLRLIQITCOMPRA/(CASE WHEN IT.QTDITCOMPRA IS NULL OR IT.QTDITCOMPRA=0 THEN 1 " );// PRE�O " R$ UNIT "
		sSQL.append( "ELSE IT.QTDITCOMPRA END)) PRECOITCOMPRA " ); 
		sSQL.append( "FROM EQPRODUTO P, CPITCOMPRA IT, CPCOMPRA C ");
		sSQL.append( "WHERE P.CODEMP=? AND P.CODFILIAL=? AND ");
		sSQL.append( "C.CODEMP=IT.CODEMP AND C.CODFILIAL=IT.CODFILIAL AND ");
		sSQL.append( "C.CODCOMPRA=IT.CODCOMPRA AND ");
		sSQL.append( "IT.CODEMPPD=P.CODEMP AND IT.CODFILIALPD=P.CODFILIAL AND ");
		sSQL.append( "IT.CODPROD=P.CODPROD AND IT.CODCOMPRA = ( SELECT FIRST 1 C2.CODCOMPRA FROM ");
		sSQL.append( "CPCOMPRA C2, CPITCOMPRA IT2 ");
		sSQL.append( "WHERE C2.CODEMP=IT2.CODEMP AND C2.CODFILIAL=IT2.CODFILIAL AND ");
		sSQL.append( "C2.CODCOMPRA=IT2.CODCOMPRA AND IT2.CODEMP=IT.CODEMP AND ");
		sSQL.append( "IT2.CODFILIAL=IT.CODFILIAL AND IT2.CODEMPPD=IT.CODEMPPD AND ");
		sSQL.append( "IT2.CODFILIALPD=IT.CODFILIALPD AND ");
		sSQL.append( "IT2.CODPROD=IT.CODPROD ");
		sSQL.append( sFiltro.toString() );
		sSQL.append( "ORDER BY C2.DTEMITCOMPRA DESC ) ");
		sSQL.append( " ORDER BY " );
		sSQL.append( rgOrdem.getVlrString() );
		
		try {
		
			ps = con.prepareStatement( sSQL.toString() );
			ps.setInt( 1, Aplicativo.iCodEmp );
			ps.setInt( 2, ListaCampos.getMasterFilial( "EQPRODUTO" ) );
			rs = ps.executeQuery();
			
			
		} catch ( Exception e ) {
		
			Funcoes.mensagemErro( this, "Erro ao buscar dados do produto !\n" + e.getMessage());
			e.printStackTrace();
		}

		if("T".equals( rgTipo.getVlrString() ) ){
			
			imprimeTexto( rs, bVisualizar, sCab.toString() );
			
		}else{
			
			imprimeGrafico( rs, bVisualizar, sCab.toString() );
			
		}
	}
	
	public void imprimeTexto( final ResultSet rs, final boolean bVisualizar, final String sCab ){
		
		String sLinFina = Funcoes.replicate( "-", 133 );
		String sLinDupla = Funcoes.replicate( "=", 133 );
		ImprimeOS imp = null;
		int linPag = 0;
		
		try {

			imp = new ImprimeOS( "", con );
			linPag = imp.verifLinPag() - 1;
			imp.montaCab();
			imp.setTitulo( "Relat�rio de �ltimas compras/Produto" );
			imp.addSubTitulo( sCab );
			imp.limpaPags();
			
			while ( rs.next() ) {
				
				if ( imp.pRow() >= linPag - 1 ) {
					imp.pulaLinha( 1, imp.comprimido() );
					imp.say( 0, "+" + sLinFina + "+" );
					imp.incPags();
					imp.eject();
				}

				if ( imp.pRow() == 0 ) {
					imp.impCab( 136, true );
					imp.pulaLinha( 0, imp.comprimido() );
					imp.say( 0, "|" + sLinFina + "|" );
					
					imp.pulaLinha( 1, imp.comprimido() );
					imp.say( 0, "|" );
					imp.say( 5, "C�d." );
					imp.say( 11, "|" );
					imp.say( 13, "Descri��o" );
					imp.say( 45, "|" );
					imp.say( 47, "UN" );
					imp.say( 52, "|" );
					imp.say( 54, "R$ Unit" );
					imp.say( 64, "|" );
					imp.say( 66, "IPI" );
					imp.say( 73, "|" );
					imp.say( 75, "Sub-Total" );
					imp.say( 88, "|" );
					imp.say( 90, "Frete" );
					imp.say( 97, "|" );
					imp.say( 99, "R$ Total" );
					imp.say( 112, "|" );
					imp.say( 114, "�lt. compra" );
					imp.say( 125, "|" );
					imp.say( 129, "D�c." );
					imp.say( 135, "|" );
					imp.pulaLinha( 1, imp.comprimido() );
					imp.say( 0, "|" + sLinFina + "|" );
					
				}
				
				imp.pulaLinha( 1, imp.comprimido() );
				imp.say( 0, "|" );
				imp.say( 3,  rs.getString( "CODPROD" ).trim() != null ? rs.getString( "CODPROD" ): "" );
				imp.say( 11, "|" );
				imp.say( 13, Funcoes. copy( rs.getString( "DESCPROD" ).trim(), 31 ) );
				imp.say( 45, "|" );
				imp.say( 47,  rs.getString( "CODUNID" ).trim() != null ? rs.getString( "CODUNID" ).trim() : "" );
				imp.say( 52, "|" );
				imp.say( 54, Funcoes.strDecimalToStrCurrency( 9, 2, String.valueOf( rs.getFloat( "PRECOITCOMPRA" ) ) ) );
				imp.say( 64, "|" );
				imp.say( 66, Funcoes.strDecimalToStrCurrency( 6, 2 , String.valueOf( rs.getFloat( "IPIITCOMPRA" ) ) ) );
				imp.say( 73, "|" );
				imp.say( 75, Funcoes.strDecimalToStrCurrency( 12, 2 , String.valueOf( rs.getFloat( "VLRSUBTOTAL" ) ) ) );
				imp.say( 88, "|" );
				imp.say( 90, Funcoes.strDecimalToStrCurrency( 6, 2 , String.valueOf( rs.getFloat( "FRETEITCOMPRA" ) ) ) );
				imp.say( 97, "|" );
				imp.say( 99, Funcoes.strDecimalToStrCurrency( 12, 2 , String.valueOf( rs.getFloat( "VLRLIQITCOMPRA" ) ) ) );
				imp.say( 112, "|" );
				imp.say( 114, Funcoes.sqlDateToStrDate( rs.getDate( "DTEMITCOMPRA" ) ) );
				imp.say( 125, "|" );
				imp.say( 127, rs.getString( "DOCCOMPRA" ) );
				imp.say( 135, "|" );
				
			}
			
			imp.pulaLinha( 1, imp.comprimido() );
			imp.say( 0, "|" + sLinDupla + "|" );
			imp.eject();
			imp.fechaGravacao();

			if ( bVisualizar ) {
				imp.preview( this );
			}
			
			else {
				imp.print();
			}
			
		}catch ( Exception err ) {
				
			Funcoes.mensagemErro( this, "Erro ao montar relat�rio! " + err.getMessage(), true, con, err );
			err.printStackTrace();
		}
	}
	public void imprimeGrafico( final ResultSet rs, final boolean bVisualizar, final String sCab ){

		HashMap<String, Object> hParam = new HashMap<String, Object>();

		hParam.put( "CODEMP", Aplicativo.iCodEmp );
		hParam.put( "CODFILIAL", ListaCampos.getMasterFilial( "EQPRODUTO" ));
		hParam.put( "FILTROS", sCab );
		
		FPrinterJob dlGr = new FPrinterJob( "relatorios/CpProd.jasper", "�ltimas Compras/produto", null, rs, hParam, this );
		
		if ( bVisualizar ) {
			
			dlGr.setVisible( true );
		
		}
		else {		
			try {				
			
				JasperPrintManager.printReport( dlGr.getRelatorio(), true );				
			
			} catch ( Exception err ) {					
			
					Funcoes.mensagemErro( this, "Erro na impress�o do relat�rio de �ltimas compras/produto!\n" + err.getMessage(), true, con, err );
			}
		}
	}
	
	public void setConexao(Connection cn) {
		
		super.setConexao( cn );
		lcGrupo.setConexao( cn );
		lcMarca.setConexao( cn );
		lcProduto.setConexao( cn );
	}
}
