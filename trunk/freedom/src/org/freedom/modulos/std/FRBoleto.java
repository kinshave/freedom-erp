/**
 * @version 19/12/2003 <BR>
 * @author Setpoint Inform�tica Ltda./Fernando Oliveira da Silva <BR>
 *
 * Projeto: Freedom <BR>
 *  
 * Pacote: org.freedom.modulos.std <BR>
 * Classe: @(#)FRBoleto.java <BR>
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

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import net.sf.jasperreports.engine.JasperPrintManager;

import org.freedom.componentes.GuardaCampo;
import org.freedom.componentes.ImprimeOS;
import org.freedom.componentes.JCheckBoxPad;
import org.freedom.componentes.JLabelPad;
import org.freedom.componentes.JTextFieldFK;
import org.freedom.componentes.JTextFieldPad;
import org.freedom.componentes.ListaCampos;
import org.freedom.funcoes.Extenso;
import org.freedom.funcoes.Funcoes;
import org.freedom.telas.Aplicativo;
import org.freedom.telas.FPrinterJob;
import org.freedom.telas.FRelatorio;

public class FRBoleto extends FRelatorio {

	private static final long serialVersionUID = 1L;

	public JTextFieldPad txtCodModBol = new JTextFieldPad( JTextFieldPad.TP_INTEGER, 8, 0 );

	private JTextFieldFK txtDescModBol = new JTextFieldFK( JTextFieldPad.TP_STRING, 50, 0 );

	public JTextFieldPad txtCodVenda = new JTextFieldPad( JTextFieldPad.TP_INTEGER, 8, 0 );

	public JTextFieldFK txtDocVenda = new JTextFieldFK( JTextFieldPad.TP_INTEGER, 8, 0 );

	private JTextFieldFK txtDataVenda = new JTextFieldFK( JTextFieldPad.TP_DATE, 10, 0 );

	private JTextFieldPad txtCodCli = new JTextFieldPad( JTextFieldPad.TP_INTEGER, 8, 0 );

	private JTextFieldFK txtRazCli = new JTextFieldFK( JTextFieldPad.TP_STRING, 50, 0 );

	private JTextFieldPad txtParc = new JTextFieldPad( JTextFieldPad.TP_INTEGER, 8, 0 );
	
	private JTextFieldPad txtDtIni = new JTextFieldPad( JTextFieldPad.TP_DATE, 10, 0 );
	
	private JTextFieldPad txtDtFim = new JTextFieldPad( JTextFieldPad.TP_DATE, 10, 0 );

	private JTextFieldPad txtCodBanco = new JTextFieldPad( JTextFieldPad.TP_STRING, 8, 0 );

	private JTextFieldFK txtNomeBanco = new JTextFieldFK( JTextFieldPad.TP_STRING, 50, 0 );

	private JTextFieldPad txtCodTpCob = new JTextFieldPad( JTextFieldPad.TP_INTEGER, 8, 0 );

	private JTextFieldFK txtDescTpCob = new JTextFieldFK( JTextFieldPad.TP_STRING, 50, 0 );
	
	private JCheckBoxPad cbTipoImp = new JCheckBoxPad("Impress�o gr�fica","S","N");

	private ListaCampos lcModBol = new ListaCampos( this );

	private ListaCampos lcVenda = new ListaCampos( this );

	private ListaCampos lcCli = new ListaCampos( this );

	private ListaCampos lcBanco = new ListaCampos( this );

	private ListaCampos lcTipoCob = new ListaCampos( this );

	private JInternalFrame fExt = null;

	private String sInfoMoeda[] = new String[ 4 ];

	public FRBoleto() {

		this( null );
	}

	public FRBoleto( JInternalFrame fExt ) {

		setTitulo( "Impress�o de boleto" );
		setAtribos( 80, 80, 545, 280 );

		this.fExt = fExt;
		
		montaListaCampos();
		montaTela();

		//txtCodVenda.setRequerido( true );

		Calendar cal = Calendar.getInstance();			
		txtDtFim.setVlrDate( cal.getTime() );		
		//cal.set( cal.get( Calendar.YEAR ), cal.get( Calendar.MONTH ) - 1, cal.get( Calendar.DATE ) );
		txtDtIni.setVlrDate( cal.getTime() );

	}
	
	private void montaListaCampos() {
		
		/********************
		 * MODELO DE BOLETO *
		 ********************/
		
		lcModBol.add( new GuardaCampo( txtCodModBol, "CodModBol", "C�d.mod.", ListaCampos.DB_PK, true ) );
		lcModBol.add( new GuardaCampo( txtDescModBol, "DescModBol", "Descri��o do modelo de boleto", ListaCampos.DB_SI, false ) );
		lcModBol.setReadOnly( true );
		lcModBol.montaSql( false, "MODBOLETO", "FN" );
		txtCodModBol.setTabelaExterna( lcModBol );
		txtCodModBol.setFK( true );
		txtCodModBol.setNomeCampo( "CodModBol" );

		/*********
		 * VENDA *
		 *********/
		
		lcVenda.add( new GuardaCampo( txtCodVenda, "CodVenda", "C�d.venda", ListaCampos.DB_PK, true ) );
		lcVenda.add( new GuardaCampo( txtDocVenda, "DocVenda", "Doc.", ListaCampos.DB_SI, false ) );
		lcVenda.add( new GuardaCampo( txtDataVenda, "DtEmitVenda", "Data", ListaCampos.DB_SI, false ) );
		lcVenda.add( new GuardaCampo( txtCodCli, "CodCli", "C�d.cli.", ListaCampos.DB_FK, true ) );
		lcVenda.setReadOnly( true );
		lcVenda.montaSql( false, "VENDA", "VD" );
		txtCodVenda.setTabelaExterna( lcVenda );
		txtCodVenda.setFK( true );
		txtCodVenda.setNomeCampo( "CodVenda" );

		/***********
		 * CLIENTE *
		 ***********/
		
		lcCli.add( new GuardaCampo( txtCodCli, "CodCli", "C�d.cli.", ListaCampos.DB_PK, false ) );
		lcCli.add( new GuardaCampo( txtRazCli, "RazCli", "Raz�o social do cliente", ListaCampos.DB_SI, false ) );
		lcCli.setReadOnly( true );
		lcCli.montaSql( false, "CLIENTE", "VD" );
		txtCodCli.setTabelaExterna( lcCli );
		
		/*********
		 * BANCO *
		 *********/		
		
		lcBanco.add( new GuardaCampo( txtCodBanco, "CodBanco", "C�d.banco", ListaCampos.DB_PK, false ) );
		lcBanco.add( new GuardaCampo( txtNomeBanco, "NomeBanco", "Nome do Banco", ListaCampos.DB_SI, false ) );
		lcBanco.setReadOnly( true );
		lcBanco.montaSql( false, "BANCO", "FN" );
		txtCodBanco.setTabelaExterna( lcBanco );
		txtCodBanco.setPK( true );
		txtCodBanco.setNomeCampo( "CodBanco" );
		txtCodBanco.setListaCampos( lcBanco );
		
		/********************
		 * TIPO DE COBRAN�A *
		 ********************/		
		
		lcTipoCob.add( new GuardaCampo( txtCodTpCob, "CodTipoCob", "C�d.tp.cob.", ListaCampos.DB_PK, false ) );
		lcTipoCob.add( new GuardaCampo( txtDescTpCob, "DescTipoCob", "Descri��o do tipo de cobran�a", ListaCampos.DB_SI, false ) );
		lcTipoCob.setReadOnly( true );
		lcTipoCob.montaSql( false, "TIPOCOB", "FN" );
		txtCodTpCob.setTabelaExterna( lcTipoCob );
		txtCodTpCob.setPK( true );
		txtCodTpCob.setNomeCampo( "CodTipoCob" );
		txtCodTpCob.setListaCampos( lcTipoCob );
	}
	
	private void montaTela() {
		
		adic( new JLabelPad( "Venda" ), 7, 10, 80, 20 );
		adic( txtCodVenda, 7, 30, 80, 20 );
		adic( new JLabelPad( "Doc." ), 90, 10, 97, 20 );
		adic( txtDocVenda, 90, 30, 97, 20 );
		adic( new JLabelPad( "Data" ), 190, 10, 97, 20 );
		adic( txtDataVenda, 190, 30, 97, 20 );
		adic( new JLabelPad( "Cliente" ), 290, 10, 230, 20 );
		adic( txtRazCli, 290,30, 230, 20 );
		/*adic( new JLabelPad( "C�d.mod." ), 7, 50, 300, 20 );
		adic( txtCodModBol, 7, 70, 80, 20 );
		adic( new JLabelPad( "Descri��o do modelo" ), 90, 50, 300, 20 );
		adic( txtDescModBol, 90, 70, 300, 20 );*/
		adic( new JLabelPad( "C�d.banco" ), 7, 50, 80, 20 );
		adic( txtCodBanco, 7, 70, 80, 20 );
		adic( new JLabelPad( "Nome do banco" ), 90, 50, 430, 20 );
		adic( txtNomeBanco, 90, 70, 430, 20 );
		adic( new JLabelPad( "C�d.tp.cob." ), 7, 90, 300, 20 );
		adic( txtCodTpCob, 7, 110, 80, 20 );
		adic( new JLabelPad( "Descri��o do tipo de cobran�a" ), 90, 90, 430, 20 );
		adic( txtDescTpCob, 90, 110, 430, 20 );
		
		JLabel periodo = new JLabel( "Per�odo", SwingConstants.CENTER );
		periodo.setOpaque( true );
		adic( periodo, 25, 130, 60, 20 );		
		JLabel borda = new JLabel();
		borda.setBorder( BorderFactory.createEtchedBorder() );
		adic( borda, 7, 140, 296, 45 );		
		adic( txtDtIni, 25, 155, 110, 20 );
		adic( new JLabel( "at�", SwingConstants.CENTER ), 135, 155, 40, 20 );
		adic( txtDtFim, 175, 155, 110, 20 );		

		adic( new JLabelPad( "Nro.parcela" ), 310, 140, 100, 20 );
		adic( txtParc, 310, 160, 70, 20 );
		adic( cbTipoImp, 390, 150, 150, 30);
	}

	private String aplicCampos( ResultSet rs, String[] sNat ) {
	
		PreparedStatement ps = null;
		ResultSet rs2 = null;
		Date dCampo = null;
		String sRet = null;
		String sTxa = null;
		String sCampo = null;
	
		try {
			
			ps = con.prepareStatement( "SELECT TXAMODBOL FROM FNMODBOLETO WHERE CODEMP=? AND CODFILIAL=? AND CODMODBOL=?" );
			ps.setInt( 1, Aplicativo.iCodEmp );
			ps.setInt( 2, lcModBol.getCodFilial() );
			ps.setInt( 3, txtCodModBol.getVlrInteger().intValue() );
			
			rs2 = ps.executeQuery();
			
			if ( rs2.next() ) {
				
				sTxa = rs2.getString( "TxaModBol" );
				sCampo = "";
				dCampo = null;
	
				// Aplicando campos de dados:
				// Estes '\\' que aparecem por ai..s�o para anular caracteres especiais de "express�o regular".
	
				if ( sTxa != null ) {
					if ( ( dCampo = rs.getDate( "DtVencItRec" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[VENCIMEN]", Funcoes.sqlDateToStrDate( dCampo ) );
					if ( ( dCampo = rs.getDate( "DtEmitVenda" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[DATADOC_]", Funcoes.sqlDateToStrDate( dCampo ) );
					if ( ( sCampo = rs.getString( "CodRec" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[CODREC]", Funcoes.alinhaDir( sCampo, 8 ) );
					if ( ( sCampo = rs.getString( "DocVenda" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[__DOCUMENTO__]", Funcoes.alinhaDir( sCampo, 15 ) );
					if ( ( sCampo = rs.getString( "NParcItRec" ) ) != null ) {
						sTxa = sTxa.replaceAll( "\\[P]", Funcoes.copy( sCampo, 0, 3 ) );
						if ( rs.getInt( 1 ) > 1 )
							sTxa = sTxa.replaceAll( "\\[A]", "" + ( (char) ( rs.getInt( "NParcItRec" ) + 64 ) ) );
					}
					if ( ( sCampo = rs.getInt( 1 ) + "" ) != null )
						sTxa = sTxa.replaceAll( "\\[T]", "/" + Funcoes.copy( sCampo, 0, 2 ) );
					if ( ( sCampo = rs.getString( "VlrParcItRec" ) ) != null && rs.getDouble( "VlrParcItRec" ) != 0 ) {
						sTxa = sTxa.replaceAll( "\\[VALOR_DOCUMEN]", Funcoes.strDecimalToStrCurrency( 15, 2, sCampo ) );
						sTxa = sTxa.replaceAll( "\\[VALOR_EXTENSO]", Extenso.extenso( rs.getDouble( "VlrParcItRec" ), sInfoMoeda[ 0 ], sInfoMoeda[ 1 ], sInfoMoeda[ 2 ], sInfoMoeda[ 3 ] ) );
					}
					if ( ( sCampo = rs.getString( "VlrApagItRec" ) ) != null && rs.getDouble( "VlrApagItRec" ) != 0 )
						sTxa = sTxa.replaceAll( "\\[VLIQ_DOCUMENT]", Funcoes.strDecimalToStrCurrency( 15, 2, sCampo ) );
					if ( ( sCampo = rs.getString( "VlrDescItRec" ) ) != null && rs.getDouble( "VlrDescItRec" ) != 0 )
						sTxa = sTxa.replaceAll( "\\[DESC_DOCUMENT]", Funcoes.strDecimalToStrCurrency( 15, 2, sCampo ) );
					if ( ( sCampo = rs.getString( "CodCli" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[CODCLI]", Funcoes.copy( sCampo, 0, 8 ) );
					if ( ( sCampo = rs.getString( "RazCli" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[_____________RAZAO____DO____CLIENTE_____________]", Funcoes.copy( sCampo, 0, 50 ) );
					if ( ( sCampo = rs.getString( "NomeCli" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[_____________NOME_____DO____CLIENTE_____________]", Funcoes.copy( sCampo, 0, 50 ) );
					if ( ( sCampo = rs.getString( "CpfCli" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[CPF/CNPJ_ CLIENT]", Funcoes.setMascara( sCampo, "###.###.###-##" ) );
					else if ( ( sCampo = rs.getString( "CnpjCli" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[CPF/CNPJ_ CLIENT]", Funcoes.setMascara( sCampo, "##.###.###/####-##" ) );
					if ( ( sCampo = rs.getString( "RgCli" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[____IE/RG____CLIENTE]", Funcoes.copy( sCampo, 0, 22 ) );
					else if ( ( sCampo = rs.getString( "InscCli" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[____IE/RG____CLIENTE]", Funcoes.copy( sCampo, 0, 22 ) );
					if ( ( sCampo = rs.getString( "EndCob" ) ) != null || ( sCampo = rs.getString( "EndCli" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[____________ENDERECO____DO____CLIENTE___________]", sCampo.trim() );
					if ( ( sCampo = rs.getString( "NumCob" ) ) != null || ( sCampo = rs.getString( "NumCli" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[NUMERO]", sCampo );
					if ( ( sCampo = rs.getString( "ComplCob" ) ) != null || ( sCampo = rs.getString( "ComplCli" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[____COMPLEMENTO___]", sCampo.trim() );
					if ( ( sCampo = rs.getString( "CepCob" ) ) != null || ( sCampo = rs.getString( "CepCli" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[__CEP__]", Funcoes.setMascara( sCampo, "#####-###" ) );
					if ( ( sCampo = rs.getString( "BairCob" ) ) != null || ( sCampo = rs.getString( "BairCli" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[___________BAIRRO___________]", sCampo.trim() );
					if ( ( sCampo = rs.getString( "CidCob" ) ) != null || ( sCampo = rs.getString( "CidCli" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[___________CIDADE___________]", sCampo.trim() );
					if ( ( sCampo = rs.getString( "UfCob" ) ) != null || ( sCampo = rs.getString( "UfCli" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[UF]", Funcoes.copy( sCampo, 0, 2 ) );
					if ( ( sCampo = rs.getString( "FoneCli" ) ) != null )
						sTxa = sTxa.replaceAll( "\\[__TELEFONE___]", Funcoes.setMascara( sCampo.trim(), "####-####" ) );
					if ( ( sCampo = rs.getString( "DDDCli" ) ) != null || ( sCampo = "(" + rs.getString( "DDDCli" ) ) + ")" != null )
						sTxa = sTxa.replaceAll( "\\[DDD]", Funcoes.copy( sCampo, 0, 5 ) );
					if ( ( sCampo = sNat[ 0 ] ) != null )
						sTxa = sTxa.replaceAll( "\\[CODNAT]", Funcoes.copy( sCampo, 0, 8 ) );
					if ( ( sCampo = sNat[ 1 ] ) != null )
						sTxa = sTxa.replaceAll( "\\[______________NATUREZA_DA_OPERACAO______________]", Funcoes.copy( sCampo, 0, 50 ) );
	
					// Aplicar campos especiais de dados:
	
					int iPos = 0;
					while ( ( iPos = sTxa.indexOf( "%_VAL", iPos + 1 ) ) > 0 ) {
						double dVal = 0;
						String sCaixa = sTxa.substring( iPos - 9, iPos );
						sCaixa += "\\" + sTxa.substring( iPos, iPos + 6 );
						dVal = rs.getDouble( "VlrParcitRec" );
						dVal *= Double.parseDouble( sTxa.substring( iPos - 8, iPos ) ) / 100;
						sTxa = sTxa.replaceAll( "\\" + sCaixa, Funcoes.strDecimalToStrCurrency( 15, 2, new BigDecimal( dVal ).setScale( 2, BigDecimal.ROUND_HALF_UP ).toString() ) );
					}
					iPos = 0;
					while ( ( iPos = sTxa.indexOf( "+_VAL", iPos + 1 ) ) > 0 ) {
						double dVal = 0;
						String sCaixa = sTxa.substring( iPos - 9, iPos );
						sCaixa += "\\" + sTxa.substring( iPos, iPos + 6 );
						dVal = rs.getDouble( "VlrParcitRec" );
						dVal += Double.parseDouble( sTxa.substring( iPos - 8, iPos ) );
						sTxa = sTxa.replaceAll( "\\" + sCaixa, Funcoes.strDecimalToStrCurrency( 15, 2, new BigDecimal( dVal ).setScale( 2, BigDecimal.ROUND_HALF_UP ).toString() ) );
					}
					iPos = 0;
					while ( ( iPos = sTxa.indexOf( "-_VAL", iPos + 1 ) ) > 0 ) {
						double dVal = 0;
						String sCaixa = sTxa.substring( iPos - 9, iPos );
						sCaixa += "\\" + sTxa.substring( iPos, iPos + 6 );
						dVal = rs.getDouble( "VlrParcitRec" );
						dVal -= Double.parseDouble( sTxa.substring( iPos - 8, iPos ) );
						sTxa = sTxa.replaceAll( "\\" + sCaixa, Funcoes.strDecimalToStrCurrency( 15, 2, new BigDecimal( dVal ).setScale( 2, BigDecimal.ROUND_HALF_UP ).toString() ) );
					}
					iPos = 0;
					while ( ( iPos = sTxa.indexOf( "+_VEN", iPos + 1 ) ) > 0 ) {
						GregorianCalendar cVal = new GregorianCalendar();
						String sCaixa = sTxa.substring( iPos - 4, iPos );
						sCaixa += "\\" + sTxa.substring( iPos, iPos + 6 );
						cVal.setTime( rs.getDate( "DtVencItRec" ) );
						cVal.set( Calendar.DATE, cVal.get( Calendar.DATE ) + Integer.parseInt( sTxa.substring( iPos - 3, iPos ) ) );
						sTxa = sTxa.replaceAll( "\\" + sCaixa, Funcoes.dateToStrDate( cVal.getTime() ) );
					}
	
					sRet = sTxa;
				}
			}
	
			// Ajustando campos de a��o:
	
			sRet = sRet.replaceAll( "\\<LP\\>.*].*\\<_LP\\>", "" );
			sRet = sRet.replaceAll( "\\<[_]*LP\\>", "" );
	
			// Tirando campos n�o setados:
	
			Pattern p = Pattern.compile( "\\[.*\\]" );
			Matcher m = p.matcher( sRet );
			StringBuffer sb = new StringBuffer();
			
			while ( m.find() ) {
				m.appendReplacement( sb, Funcoes.replicate( " ", m.end() - m.start() ) );
			}
			
			m.appendTail( sb );
			sRet = sb.toString();
			
			rs2.close();
			ps.close();
			
			/*if ( ! con.getAutoCommit() ) {
				con.commit();
			}*/
		} catch ( SQLException err ) {
			Funcoes.mensagemErro( this, "Erro na consulta ao modelo de boleto!\n" + err.getMessage(), true, con, err );
			err.printStackTrace();
		} 
	
		return sRet;
	}

	private String[] getMoeda() {
		
		String sRet[] = new String[ 5 ];
		StringBuilder sSQL = new StringBuilder();
		
		try {
			
			sSQL.append( "SELECT M.SINGMOEDA,M.PLURMOEDA,M.DECSMOEDA,M.DECPMOEDA,M.CODFBNMOEDA FROM FNMOEDA M, SGPREFERE1 P " );
			sSQL.append( "WHERE M.CODMOEDA=P.CODMOEDA AND M.CODEMP=P.CODEMPMO AND M.CODFILIAL=P.CODFILIALMO " );
			sSQL.append( "AND P.CODEMP=? AND P.CODFILIAL=?" );
			
			PreparedStatement ps = con.prepareStatement( sSQL.toString() );
			ps.setInt( 1, Aplicativo.iCodEmp );
			ps.setInt( 2, Aplicativo.iCodFilial );
			ResultSet rs = ps.executeQuery();
			
			if ( rs.next() ) {
				sRet[ 0 ] = rs.getString( "SingMoeda" ).trim();
				sRet[ 1 ] = rs.getString( "PlurMoeda" ).trim();
				sRet[ 2 ] = rs.getString( "DecSMoeda" ).trim();
				sRet[ 3 ] = rs.getString( "DecPMoeda" ).trim();
				sRet[ 4 ] = rs.getString( "CodFbnMoeda" ).trim();
			}
			rs.close();
			ps.close();
			
			/*if ( ! con.getAutoCommit() ) {
				con.commit();
			}*/
		} catch ( SQLException err ) {
			Funcoes.mensagemErro( null, "Erro ao buscar a moeda padr�o!\n" + err.getMessage(), true, con, err );
			err.printStackTrace();
		}
	
		if ( sRet == null ) {
			Funcoes.mensagemErro( null, "A moeda padr�o pode n�o estar ajustada no prefer�ncias!" );
		}
		
		return sRet;
	}

	private String getClassModelo(final String preImpModbol, final String classModBol) {
		
		String retorno = null;
		
		if ( "N".equals( preImpModbol) ) {
			retorno = classModBol;
		} 
		return retorno;
		
	}
	
	private HashMap<String,Object> getParametros() {
		
		HashMap<String,Object> parametros = new HashMap<String, Object>();
		
		String agencia = null;
		String numconta = null;
		String convenio = null;
		String instrucoes = null;
		String localpag = null;
		String razemp = null;
		
		try {
			
			StringBuilder sql = new StringBuilder();
			
			sql.append( "SELECT F.RAZFILIAL, C.AGENCIACONTA, MB.NUMCONTA, MB.DESCLPMODBOL, ");
			sql.append( "MB.INSTPAGMODBOL, B.IMGBOLBANCO, C.CONVCOBCONTA " );
			sql.append( "FROM SGFILIAL F, FNCONTA C, FNMODBOLETO MB, FNBANCO B " );
			sql.append( "WHERE MB.CODEMP=? AND MB.CODFILIAL=? AND MB.CODMODBOL =? " );
			sql.append( "AND F.CODEMP=MB.CODEMP AND F.CODFILIAL=MB.CODFILIAL " );
			sql.append( "AND C.CODEMP=MB.CODEMPCC AND C.CODFILIAL=MB.CODFILIALCC AND C.NUMCONTA=MB.NUMCONTA " );
			sql.append( "AND B.CODEMPMB=MB.CODEMP AND B.CODFILIALMB=MB.CODFILIAL AND B.CODMODBOL=MB.CODMODBOL" );
			
			PreparedStatement ps = con.prepareStatement( sql.toString() );
			ps.setInt( 1, Aplicativo.iCodEmp );
			ps.setInt( 2, ListaCampos.getMasterFilial( "FNMODBOLETO" ) );
			ps.setInt( 3, txtCodModBol.getVlrInteger() );
			ResultSet rs = ps.executeQuery();
			
			if ( rs.next() ) {
				
				if (rs.getString("AGENCIACONTA")==null) {
					agencia = "";
				} else {
					agencia = rs.getString( "AGENCIACONTA" );
				}
				if (rs.getString( "NUMCONTA" )==null) {
					numconta = "";
				} else {
					numconta = rs.getString( "NUMCONTA" );
				}
				if (rs.getString( "CONVCOBCONTA" )==null) {
					convenio = "";
				} else {
					convenio = rs.getString( "CONVCOBCONTA" );
				}
				instrucoes = rs.getString( "INSTPAGMODBOL" );
				localpag = rs.getString( "DESCLPMODBOL" );
				razemp = rs.getString( "RAZFILIAL" );
			}	
		}
		catch ( Exception e ) {
	
			Funcoes.mensagemErro( this, "Erro ao buscar parametros!\n" + e.getMessage() );
			e.printStackTrace();
		}
		
		parametros.put( "AGENCIA", agencia );
		parametros.put( "NUMCONTA", numconta );
		parametros.put( "CONVENIO", convenio );
		parametros.put( "CODEMP", Aplicativo.iCodEmp );
		parametros.put( "CODFILIAL", ListaCampos.getMasterFilial( "FNITRECEBER" ) );
		parametros.put( "CODVENDA", txtCodVenda.getVlrInteger() );
		parametros.put( "INSTRUCOES", instrucoes );
		parametros.put( "LOCALPAG", localpag );
		parametros.put( "RAZEMP", razemp );
			
		return parametros;
	}
	
	public void imprimir( boolean bVisualizar ) {
		
		/*if ( txtCodVenda.getVlrString().equals( "" ) ) {
			Funcoes.mensagemInforma( this, "C�digo da venda em branco!" );
			return;
		}
		else if ( txtCodModBol.getVlrString().equals( "" ) ) {
			Funcoes.mensagemInforma( this, "C�digo do modelo em branco!" );
			return;
		}*/		
		
		try {

			PreparedStatement ps = null;
			ResultSet rs = null;
			StringBuilder sSQL = new StringBuilder();
			StringBuilder sSQLNat = new StringBuilder();
			String sVal = null;
			String sParc = "";
			String[] sNat = new String[ 2 ];
			ImprimeOS imp = null;			
	
			if ( txtParc.getVlrInteger().intValue() > 0 ) {
				sParc = " AND ITR.NPARCITREC = " + txtParc.getVlrString();
			}
	
			imp = new ImprimeOS( "", con );
			imp.verifLinPag();
			imp.setTitulo( "Boleto" );
			
			sSQL.append( "SELECT (SELECT COUNT(*) FROM FNITRECEBER ITR2 WHERE ITR2.CODREC=R.CODREC AND ITR2.CODEMP=R.CODEMP AND ITR2.CODFILIAL=R.CODFILIAL) PARCS," );
			sSQL.append( "ITR.DTVENCITREC,ITR.NPARCITREC,ITR.VLRAPAGITREC,ITR.VLRPARCITREC,ITR.VLRDESCITREC," );
			sSQL.append( "(ITR.VLRJUROSITREC+ITR.VLRMULTAITREC) VLRMULTA," );
			sSQL.append( "R.DOCREC,ITR.CODBANCO, B.DVBANCO," );
			sSQL.append( "B.IMGBOLBANCO LOGOBANCO01, B.IMGBOLBANCO LOGOBANCO02, B.IMGBOLBANCO LOGOBANCO03, " );
			sSQL.append( "MB.CARTCOB, MB.ESPDOCMODBOL ESPDOC, MB.ACEITEMODBOL ACEITE, MB.MDECOB, " );
			sSQL.append( "MB.PREIMPMODBOL, MB.CLASSMODBOL, V.DTEMITVENDA, V.DOCVENDA," );
			sSQL.append( "C.CODCLI,C.RAZCLI,C.NOMECLI,C.CPFCLI,C.CNPJCLI,C.RGCLI,C.INSCCLI," );
			sSQL.append( "C.ENDCLI,C.NUMCLI,C.COMPLCLI,C.CEPCLI,C.BAIRCLI,C.CIDCLI,C.UFCLI," );
			sSQL.append( "C.ENDCOB,C.NUMCOB,C.COMPLCOB,C.CEPCOB,C.BAIRCOB,C.CIDCOB,C.UFCOB," );
			sSQL.append( "C.FONECLI,C.DDDCLI,R.CODREC, P.CODMOEDA, C.PESSOACLI, " );
			sSQL.append( "(ITR.DTVENCITREC-CAST('07.10.1997' AS DATE)) FATVENC, M.CODFBNMOEDA, ");
			sSQL.append( "IV.CODNAT, N.DESCNAT ");
			sSQL.append( "FROM VDVENDA V,VDCLIENTE C, FNRECEBER R, SGPREFERE1 P, FNMOEDA M, FNBANCO B, ");
			sSQL.append( "FNMODBOLETO MB, VDITVENDA IV, LFNATOPER N,  FNITRECEBER ITR " ); 
			sSQL.append( "WHERE ITR.CODREC=R.CODREC AND ITR.CODEMP=R.CODEMP AND ITR.CODFILIAL=R.CODFILIAL AND " );
			sSQL.append( "V.CODVENDA=R.CODVENDA AND V.CODEMP=R.CODEMPVA AND V.CODFILIAL=R.CODFILIALVA AND " );
			sSQL.append( "C.CODCLI=V.CODCLI AND C.CODEMP=V.CODEMPCL AND C.CODFILIAL=V.CODFILIALCL AND " );
			sSQL.append( "P.CODEMP=R.CODEMP AND P.CODFILIAL=R.CODFILIAL AND " );
			sSQL.append( "M.CODEMP=P.CODEMPMO AND M.CODFILIAL=P.CODFILIALMO AND M.CODMOEDA=P.CODMOEDA AND " );
			sSQL.append( "B.CODEMP=ITR.CODEMPBO AND B.CODFILIAL=ITR.CODFILIALBO AND B.CODBANCO=ITR.CODBANCO AND " );
			sSQL.append( "MB.CODEMP=B.CODEMPMB AND MB.CODFILIAL=B.CODFILIALMB AND MB.CODMODBOL=B.CODMODBOL AND  ");
			sSQL.append( "IV.CODEMP=V.CODEMP AND IV.CODFILIAL=V.CODFILIAL AND IV.TIPOVENDA=V.TIPOVENDA AND " );
			sSQL.append( "IV.CODVENDA=V.CODVENDA AND IV.CODITVENDA=( SELECT MIN(CODITVENDA) FROM VDITVENDA IV2 " );
			sSQL.append( "WHERE IV2.CODEMP=IV.CODEMP AND IV2.CODFILIAL=IV.CODFILIAL AND IV2.TIPOVENDA=IV.TIPOVENDA AND " );
			sSQL.append( "IV2.CODVENDA=IV.CODVENDA AND IV2.CODNAT IS NOT NULL ) AND " );
			sSQL.append( "N.CODEMP=IV.CODEMPNT AND N.CODFILIAL=IV.CODFILIALNT AND N.CODNAT=IV.CODNAT AND  " );
			sSQL.append( "R.CODEMPVA=? AND R.CODFILIALVA=? AND R.CODVENDA=? " );
			sSQL.append( sParc );	
			
			ps = con.prepareStatement( sSQL.toString() );
			ps.setInt( 1, Aplicativo.iCodEmp );
			ps.setInt( 2, ListaCampos.getMasterFilial( "VDVENDA" ) );
			ps.setInt( 3, txtCodVenda.getVlrInteger().intValue() );
			rs = ps.executeQuery();

			String classe = null;
			while (rs.next()) {
				classe = getClassModelo(rs.getString( "PREIMPMODBOL" ), rs.getString("CLASSMODBOL") );
				sNat[ 0 ] = rs.getString( "CODNAT" );
				sNat[ 1 ] = rs.getString( "DESCNAT" );
				if ( classe == null ) {
					imprimeTexto( bVisualizar, rs, sNat );
				}
				else {
					imprimeGrafico( bVisualizar, rs, classe );
				}
				
			}
			rs.close();
			ps.close();
			
			if ( ! con.getAutoCommit() ) {
				con.commit();
			}
			
		} catch ( Exception err ) {
			Funcoes.mensagemErro( null, "Erro ao tentar imprimir!\n" + err.getMessage(), true, con, err );
			err.printStackTrace();
		}
	}
	
	private void imprimeTexto( final boolean bVisualizar, final ResultSet rs, final String[] sNat ) throws Exception {		
		
		String sVal = null;
		ImprimeOS imp = null;	
		imp = new ImprimeOS( "", con );
		imp.verifLinPag();
		imp.setTitulo( "Boleto" );
				
		sVal = aplicCampos( rs, sNat );
			
		if ( sVal != null ) {
				
			String[] sLinhas = ( sVal + " " ).split( "\n" );
				
			for ( int i = 0; i < sLinhas.length; i++ ) {
				if ( i == 0 ) {
					imp.say( imp.pRow() + 1, 0, imp.normal() + imp.comprimido() + "" );
					imp.say( imp.pRow(), 0, sLinhas[ i ] );
				}
				else {
					imp.say( imp.pRow() + 1, 0, sLinhas[ i ] );
				}
			}
		}

		imp.fechaGravacao();
		
		if ( bVisualizar ) {
			
			if ( fExt == null ) {
				imp.preview( this );
			}
			else {
				imp.preview( fExt );
			}
		}
		else {
			imp.print();
		}
	}
	
	private void imprimeGrafico( final boolean bVisualizar, final ResultSet rs, final String classe ) {
		
		FPrinterJob dlGr = new FPrinterJob( "relatorios/" + classe, "Boleto", null, rs, getParametros(), this );

		if ( bVisualizar ) {
			dlGr.setVisible( true );
		}
		else {
			try {
				JasperPrintManager.printReport( dlGr.getRelatorio(), true );
			} catch ( Exception err ) {
				Funcoes.mensagemErro( this, "Erro ao tentar imprimir boleto!" + err.getMessage(), true, con, err );
			}
		}
	}

	public void setConexao( Connection cn ) {
	
		super.setConexao( cn );
		lcModBol.setConexao( cn );
		lcVenda.setConexao( cn );
		lcCli.setConexao( cn );
		lcBanco.setConexao( cn );
		lcTipoCob.setConexao( cn );
		sInfoMoeda = getMoeda();
	}
}
