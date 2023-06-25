/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__uploadDiskServlet_17.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 400 Resource Exhaustion
* Sinks: uploadDiskServlet
*    GoodSink: restricted upload size
*    BadSink : no restriction on upload size
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE400_Resource_Exhaustion;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

public class CWE400_Resource_Exhaustion__uploadDiskServlet_17 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            /**
             * Inspiration from:
             * http://forums.codecharge.com/posts.php?post_id=44078
             * and
             * http://commons.apache.org/downloads/download_fileupload.cgi
             * class FileUploadBase, method parseRequest()
             * class Streams, method copy()
             *
             * We don't actually parse out the filename or any of the other data since it really
             * doesn't matter for this test. (We don't care if part of the HTTP request ends up in
             * the file.
             *
             * Note that if you try to run this file, you'll always get an exception from the bad method.
             * This is because you've already read the full httprequest stream and stored it into a file.
             * So, expect the bad method to always fail if you directly run this file from eclipse.
             */
            if (request.getContentType() == null ||
            !request.getContentType().contains("multipart/form-data"))
            {
                return;
            }
            FileOutputStream out = null;
            InputStream in = null;
            try
            {
                out = new FileOutputStream("output_bad.dat");
                in = request.getInputStream();
                for (;;)
                {
                    byte[] b = new byte[1024];
                    int res = in.read(b); /* FLAW: no restriction on file size */
                    if (-1 == res)
                    {
                        break;
                    }
                    out.write(b);
                }
            }
            catch(Exception e)
            {
                log2.warning("Error!");
            }
            finally
            {
                try
                {
                    if( in != null )
                    {
                        in.close();
                    }
                }
                catch(Exception e)
                {
                    log2.warning("Error!");
                }
                finally
                {
                    try
                    {
                        if( out != null )
                        {
                            out.close();
                        }
                    }
                    catch(Exception e)
                    {
                        log2.warning("Error!");
                    }
                }
            }
            response.getWriter().write("Uploaded file!");
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            if (request.getContentType() == null ||
                    !request.getContentType().contains("multipart/form-data"))
            {
                return;
            }
            FileOutputStream out = null;
            InputStream in = null;
            try
            {
                out = new FileOutputStream("output_good.dat");
                in = request.getInputStream();
                /* set max filesize to 10 MB */
                final int MAXSIZE = 10485760;
                int bytes_read = 0;
                for (;;)
                {
                    /* FIX: max file size check */
                    if (bytes_read >= MAXSIZE)
                    {
                        response.getWriter().write("File exceeds MAXSIZE!");
                        break;
                    }
                    byte[] b = new byte[1024];
                    int res = in.read(b);
                    if (-1 == res)
                    {
                        break;
                    }
                    bytes_read += res;
                    out.write(b);
                }
            }
            catch(Exception e)
            {
                log2.warning("Error!");
            }
            finally
            {
                try
                {
                    if( in != null )
                    {
                        in.close();
                    }
                }
                catch(Exception e)
                {
                    log2.warning("Error!");
                }
                finally
                {
                    try
                    {
                        if( out != null )
                        {
                            out.close();
                        }
                    }
                    catch(Exception e)
                    {
                        log2.warning("Error!");
                    }
                }
            }
            response.getWriter().write("Uploaded file!");
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            /**
             * Inspiration from:
             * http://forums.codecharge.com/posts.php?post_id=44078
             * and
             * http://commons.apache.org/downloads/download_fileupload.cgi
             * class FileUploadBase, method parseRequest()
             * class Streams, method copy()
             *
             * We don't actually parse out the filename or any of the other data since it really
             * doesn't matter for this test. (We don't care if part of the HTTP request ends up in
             * the file.
             *
             * Note that if you try to run this file, you'll always get an exception from the bad method.
             * This is because you've already read the full httprequest stream and stored it into a file.
             * So, expect the bad method to always fail if you directly run this file from eclipse.
             */
            if (request.getContentType() == null ||
            !request.getContentType().contains("multipart/form-data"))
            {
                return;
            }
            FileOutputStream out = null;
            InputStream in = null;
            try
            {
                out = new FileOutputStream("output_bad.dat");
                in = request.getInputStream();
                for (;;)
                {
                    byte[] b = new byte[1024];
                    int res = in.read(b); /* FLAW: no restriction on file size */
                    if (-1 == res)
                    {
                        break;
                    }
                    out.write(b);
                }
            }
            catch(Exception e)
            {
                log2.warning("Error!");
            }
            finally
            {
                try
                {
                    if( in != null )
                    {
                        in.close();
                    }
                }
                catch(Exception e)
                {
                    log2.warning("Error!");
                }
                finally
                {
                    try
                    {
                        if( out != null )
                        {
                            out.close();
                        }
                    }
                    catch(Exception e)
                    {
                        log2.warning("Error!");
                    }
                }
            }
            response.getWriter().write("Uploaded file!");
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            if (request.getContentType() == null ||
                    !request.getContentType().contains("multipart/form-data"))
            {
                return;
            }
            FileOutputStream out = null;
            InputStream in = null;
            try
            {
                out = new FileOutputStream("output_good.dat");
                in = request.getInputStream();
                /* set max filesize to 10 MB */
                final int MAXSIZE = 10485760;
                int bytes_read = 0;
                for (;;)
                {
                    /* FIX: max file size check */
                    if (bytes_read >= MAXSIZE)
                    {
                        response.getWriter().write("File exceeds MAXSIZE!");
                        break;
                    }
                    byte[] b = new byte[1024];
                    int res = in.read(b);
                    if (-1 == res)
                    {
                        break;
                    }
                    bytes_read += res;
                    out.write(b);
                }
            }
            catch(Exception e)
            {
                log2.warning("Error!");
            }
            finally
            {
                try
                {
                    if( in != null )
                    {
                        in.close();
                    }
                }
                catch(Exception e)
                {
                    log2.warning("Error!");
                }
                finally
                {
                    try
                    {
                        if( out != null )
                        {
                            out.close();
                        }
                    }
                    catch(Exception e)
                    {
                        log2.warning("Error!");
                    }
                }
            }
            response.getWriter().write("Uploaded file!");
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
