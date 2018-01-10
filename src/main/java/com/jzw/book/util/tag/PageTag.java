package com.jzw.book.util.tag;

import com.jzw.book.util.PageBean;
import com.jzw.book.util.StringUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * 说明：分页标签助手类
 *
 * @author Jzw
 * @date 2018/1/3 16:16
 */
public class PageTag extends BodyTagSupport{


    /**
     * 实现分页的源
     */
    private PageBean items;

    /**
     * 请求发送的路径
     */
    private String path;


    public String getPath() {
        return path == null ? "book/select/manager/books/list_books1.controller" : this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public PageBean getItems() {
        return items;
    }

    public void setItems(PageBean items) {
        this.items = items;
    }

    @Override
    public int doStartTag() throws JspException {

        StringBuilder sbHtml = new StringBuilder();

        //当前页
        int pageNum = items.getPageNum();
        //总页码
        int pages = items.getPages();

        sbHtml.append("<form id='form_page' action='"+this.getPath()+"' method='post' enctype='application/x-www-form-urlencoded'>");
        sbHtml.append("<input type='hidden' id='form_page_input' name='pageNum' value='"+pageNum+"'/>");
        sbHtml.append("<input type='hidden' name='pageSize' value='"+items.getPageSize()+"'/>");
        if (null != items.getBookType() && 0 != items.getBookType()) {
            sbHtml.append("<input type='hidden' name='bookType' value='"+items.getBookType()+"'/>");
        }
        if (StringUtil.isNotNull(items.getLikeText())) {
            sbHtml.append("<input type='hidden' name='likeText' value='"+items.getLikeText()+"'/>");
        }
        sbHtml.append("<input type='hidden' name='status' value='"+items.getStatus()+"'/>");
        sbHtml.append("<div style='text-align: right;'>");
        sbHtml.append("每页 "+items.getPageSize()+" 行 共 "+items.getTotal()+" 行 第 "+pageNum+" 页 共 "+pages+" 页");
        sbHtml.append("    <a href='javascript:gotoPage(1)'>&lt首页</a>\n");
        sbHtml.append("    <a href='javascript:gotoPage("+(pageNum-1)+")'>上一页</a>");
        sbHtml.append("    <a href='javascript:gotoPage("+(pageNum+1)+")'>下一页</a>");
        sbHtml.append("    <a href='javascript:gotoPage("+pages+")'>尾页&gt</a>");
        sbHtml.append("    页数");
        sbHtml.append("<input type='text' id='pageNumber' style='width:20px;' />");
        sbHtml.append("<a href='javascript:jumpPage()'> GO </a>");
        sbHtml.append("</div>");
        sbHtml.append("</form>");
        sbHtml.append("<script>");
        sbHtml.append("function gotoPage(page_index){");
        sbHtml.append("var formDatePage = new FormData();");
        sbHtml.append("if ( page_index > "+pages+" ) {");
        sbHtml.append("alert('已经是最后一页！');");
        sbHtml.append("}");
        sbHtml.append("else if (page_index < 1) {");
        sbHtml.append("alert('已经是第一页！');");
        sbHtml.append("}");
        sbHtml.append("else {");
        sbHtml.append("document.getElementById('form_page_input').value=page_index;");
        sbHtml.append("document.getElementById('form_page').submit();");
        sbHtml.append("}");
        sbHtml.append("}");
        sbHtml.append("function jumpPage() {");
        sbHtml.append("var zd_index = document.getElementById('pageNumber').value;");
        sbHtml.append("if (null != zd_index) {");
        sbHtml.append("if (zd_index < 1){");
        sbHtml.append("alert('跳转页码不能小于1！');");
        sbHtml.append("}");
        sbHtml.append("else if (zd_index > "+pages+") {");
        sbHtml.append("alert('跳转页码不能大于最大页码！');");
        sbHtml.append("}");
        sbHtml.append("else {");
        sbHtml.append("gotoPage(zd_index);");
        sbHtml.append("}");
        sbHtml.append("}");
        sbHtml.append("}");
        sbHtml.append("</script>");


        try {
            pageContext.getOut().print(sbHtml.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SKIP_BODY;
    }

}
