/**
 * 
 */
package cmc.com.ktnb.util;

import java.io.File;
import java.io.FileFilter;

/**
 * @author thunt
 *
 */
public class ImageFileFilter implements FileFilter
{
  private final String[] okFileExtensions =  new String[] {"jpg", "png", "gif","tif","bmp"};

  public boolean accept(File file)
  {
    for (int i=0;i<okFileExtensions.length;i++)
    {
      if (file.getName().toLowerCase().endsWith(okFileExtensions[i]))
      {
        return true;
      }
    }
    return false;
  }
}