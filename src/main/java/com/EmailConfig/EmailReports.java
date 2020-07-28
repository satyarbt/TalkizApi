package com.EmailConfig;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.ITestListener;

import org.testng.annotations.Listeners;

import com.DataMapper.EmailMapper;
import com.DataMapper.TestSummaryMapper;
import com.Reports.ReportListner;


@Listeners(ReportListner.class)
public class EmailReports extends ReportListner implements ITestListener {

	 ReportListner ERL=new ReportListner();
	public void sendMail() {
		// Create object of Property file
		Properties props = new Properties();
		// this will set host of server- you can change based on your requirement
		props.put(EmailMapper.emailDataMap().get("host_Key"), EmailMapper.emailDataMap().get("host_value"));// use your server
		// set the port of socket factory
		props.put(EmailMapper.emailDataMap().get("socketfactory_port_key"), EmailMapper.emailDataMap().get("socketfactory_port_value"));// use your port
		// set socket factory
		props.put(EmailMapper.emailDataMap().get("socketfactory_key"), EmailMapper.emailDataMap().get("socketfactory_value"));
		// set the authentication to true
		props.put(EmailMapper.emailDataMap().get("auth_key"), EmailMapper.emailDataMap().get("auth_value"));
		// set the port of SMTP server
		props.put(EmailMapper.emailDataMap().get("smtp_port_key"), EmailMapper.emailDataMap().get("smtp_port_value"));
		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EmailMapper.emailDataMap().get("email"), EmailMapper.emailDataMap().get("password"));// provide emailid and password
			}
		});
		try {
			Message message = new MimeMessage(session);
			// Set the from address
			message.setFrom(new InternetAddress(EmailMapper.emailDataMap().get("email")));
			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EmailMapper.emailDataMap().get("receipient_email")));

			java.util.Date dt = new java.util.Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = formatter.format(dt);

//			Set subject and body and adding attachments.
			message.setSubject(EmailMapper.emailDataMap().get("projectName")+"  API Test Automation Report "+ strDate);
			
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<body>\r\n" + 
					"<div><div class=\"adM\">\r\n" + 
					"</div><p>&nbsp;</p>\r\n" + 
					"<center style=\"padding-bottom:24px\">\r\n" + 
					"<table style=\"width:600px\" width=\"600\">\r\n" + 
					"<tbody>\r\n" + 
					"<tr height=\"50\" style=\"padding-top:24px;padding-bottom:24px\">\r\n" + 
					"                    <td width=\"50%\" style=\"width:50%;padding:0\"><img style=\"width:150px\" src=\"https://www.z5x.tech/wp-content/themes/z5x/images/z5xlogo.png\" alt=\"KATALON LOGO\" class=\"CToWUd\"></td>\r\n" + 
					"                    <td width=\"50%\" valign=\"middle\" style=\"width:50%;vertical-align:middle;padding:0\">\r\n" + 
					"                        <h2 style=\"margin:0;font-size:18px;color:#9733FF;text-align:right\">Test Execution Report</h2>\r\n" + 
					"                    </td>\r\n" + 
					"                </tr>" + 
					"<td style=\"border:1px solid #dddee1;padding:24px;word-break:break-word;word-wrap:break-word\" colspan=\"2\">\r\n" + 
					"<p><strong>Dear Team, Good day!!!</strong>\r\n" + 
					"<br><br>We have executed API Testcases for <strong>Talkiz </strong>app. Here is the summary <span class=\"il\">report</span>.Please find the attachment for more details on test execution.</p>\r\n" + 
					"<table style=\"width:100%;background-color:#f5f7fa;border:1px solid #dddee1\" border=\"1\" width=\"100%\" bgcolor=\"#f5f7fa\">\r\n" + 
					"<tbody>\r\n" + 
					"<tr>\r\n" + 
					"<td style=\"width:24%\" width=\"24%\">Host Name</td>\r\n" + 
					"<td colspan=\"3\">"+TestSummaryMapper.resultMapper().get("HostName")+"</td>\r\n" + 
					"</tr>\r\n" + 
					"<tr>\r\n" + 
					"<td>Operating System</td>\r\n" + 
					"<td colspan=\"3\">"+TestSummaryMapper.resultMapper().get("OS")+"</td>\r\n" + 
					"</tr>\r\n" + 
					"<tr>\r\n" + 
					"<td>Test Suite</td>\r\n" + 
					"<td colspan=\"3\">"+TestSummaryMapper.resultMapper().get("TestSuite")+"</td>\r\n" + 
					"</tr>\r\n" + 
					"<tr>\r\n" + 
					"<td>Result</td>\r\n" + 
					"<td style=\"width:25%;color:green\" width=\"25%\">Passed: "+TestSummaryMapper.resultMapper().get("Passed")+"</td>\r\n" + 
					"<td style=\"width:25%;color:red\" width=\"25%\">Failed: "+TestSummaryMapper.resultMapper().get("Failed")+"</td>\r\n" + 
					"<td style=\"width:25%;color:red\" width=\"25%\">Error: "+TestSummaryMapper.resultMapper().get("Error")+"</td>\r\n" + 
					"</tr>\r\n" + 
					"</tbody>\r\n" + 
					"</table>\r\n" + 
					"<p><br>This email was sent automatically by Automation Team.<br><br><strong>Best Regards,<br>Z5X Automation Team</strong></p>\r\n" + 
					"</td>\r\n" + 
					"</tr>\r\n" + 
					"</tbody>\r\n" + 
					"</table>\r\n" + 
					"</center><div class=\"yj6qo\"></div><div class=\"adL\">\r\n" + 
					"</div></div>\r\n" + 
					"</body>\r\n" + 
					"</html>", "text/html");
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			File file1 = new File(System.getProperty("user.dir") +"/Reports/"+EmailMapper.emailDataMap().get("projectName")+"_API_Report"+".html");
			messageBodyPart = new MimeBodyPart();
			// BodyPart messageBodyPart2 = new MimeBodyPart();
			DataSource source = new FileDataSource(file1.getAbsolutePath());
			// DataSource source2 = new FileDataSource(file2.getAbsolutePath());
			messageBodyPart.setDataHandler(new DataHandler(source));
			// messageBodyPart2.setDataHandler(new DataHandler(source2));
			messageBodyPart.setFileName(EmailMapper.emailDataMap().get("projectName")+"_Mobile_API"+".html");
			// messageBodyPart2.setFileName("cucumber-html-reports.zip");
			multipart.addBodyPart(messageBodyPart);
			// multipart.addBodyPart(messageBodyPart2);
			message.setContent(multipart);
			// finally send the email
			Transport.send(message);
			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}

}
