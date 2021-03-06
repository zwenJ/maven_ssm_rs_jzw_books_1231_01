package com.jzw.book.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Component
public class Books implements Serializable {


    public interface AddBook{}


    private Integer bookId;

    @NotBlank(message = "商品名称不能为空！", groups = {AddBook.class})
    private String bookName;

    @NotBlank(message = "作者不能为空！", groups = {AddBook.class})
    private String bookAuthor;

    @DecimalMin(message = "价格不能小于0.0元！",value = "0.00", groups = {AddBook.class})
    private BigDecimal bookPrice;

    @NotBlank(message = "出版社不能为空！", groups = {AddBook.class})
    private String bookConcern;

    @NotBlank(message = "商品描述不能为空！", groups = {AddBook.class})
    private String bookDetails;

    private Date bookDate;

    @Min(value = 1, message = "库存必须是数字，且大于等于1！")
    private Integer bookStock;

    private Integer bookStatus;

    private Integer typeId;

    private Integer shopId;

    private boolean existImage;

    public Books() {
    }

    public Books(Integer bookId, @Min(value = 1, message = "库存必须是数字，且大于等于1！") Integer bookStock) {
        this.bookId = bookId;
        this.bookStock = bookStock;
    }

    public Books(Integer bookId) {
        this.bookId = bookId;
    }

    public boolean getExistImage() {
        return existImage;
    }

    public void setExistImage(boolean existImage) {
        this.existImage = existImage;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? "" : bookName.trim();
    }


    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? "" : bookAuthor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_books.book_price
     *
     * @return the value of b_books.book_price
     *
     * @mbg.generated Sun Dec 31 13:41:06 CST 2017
     */
    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_books.book_price
     *
     * @param bookPrice the value for b_books.book_price
     *
     * @mbg.generated Sun Dec 31 13:41:06 CST 2017
     */
    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_books.book_concern
     *
     * @return the value of b_books.book_concern
     *
     * @mbg.generated Sun Dec 31 13:41:06 CST 2017
     */
    public String getBookConcern() {
        return bookConcern;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_books.book_concern
     *
     * @param bookConcern the value for b_books.book_concern
     *
     * @mbg.generated Sun Dec 31 13:41:06 CST 2017
     */
    public void setBookConcern(String bookConcern) {
        this.bookConcern = bookConcern == null ? "" : bookConcern.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_books.book_details
     *
     * @return the value of b_books.book_details
     *
     * @mbg.generated Sun Dec 31 13:41:06 CST 2017
     */
    public String getBookDetails() {
        return bookDetails;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_books.book_details
     *
     * @param bookDetails the value for b_books.book_details
     *
     * @mbg.generated Sun Dec 31 13:41:06 CST 2017
     */
    public void setBookDetails(String bookDetails) {
        this.bookDetails = bookDetails == null ? "" : bookDetails.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_books.book_date
     *
     * @return the value of b_books.book_date
     *
     * @mbg.generated Sun Dec 31 13:41:06 CST 2017
     */
    public Date getBookDate() {
        return bookDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_books.book_date
     *
     * @param bookDate the value for b_books.book_date
     *
     * @mbg.generated Sun Dec 31 13:41:06 CST 2017
     */
    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_books.book_stock
     *
     * @return the value of b_books.book_stock
     *
     * @mbg.generated Sun Dec 31 13:41:06 CST 2017
     */
    public Integer getBookStock() {
        return bookStock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_books.book_stock
     *
     * @param bookStock the value for b_books.book_stock
     *
     * @mbg.generated Sun Dec 31 13:41:06 CST 2017
     */
    public void setBookStock(Integer bookStock) {
        this.bookStock = bookStock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_books.book_status
     *
     * @return the value of b_books.book_status
     *
     * @mbg.generated Sun Dec 31 13:41:06 CST 2017
     */
    public Integer getBookStatus() {
        return bookStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_books.book_status
     *
     * @param bookStatus the value for b_books.book_status
     *
     * @mbg.generated Sun Dec 31 13:41:06 CST 2017
     */
    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_books.type_id
     *
     * @return the value of b_books.type_id
     *
     * @mbg.generated Sun Dec 31 13:41:06 CST 2017
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_books.type_id
     *
     * @param typeId the value for b_books.type_id
     *
     * @mbg.generated Sun Dec 31 13:41:06 CST 2017
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_books.shop_id
     *
     * @return the value of b_books.shop_id
     *
     * @mbg.generated Sun Dec 31 13:41:06 CST 2017
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_books.shop_id
     *
     * @param shopId the value for b_books.shop_id
     *
     * @mbg.generated Sun Dec 31 13:41:06 CST 2017
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }


    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookConcern='" + bookConcern + '\'' +
                ", bookDetails='" + bookDetails + '\'' +
                ", bookDate=" + bookDate +
                ", bookStock=" + bookStock +
                ", bookStatus=" + bookStatus +
                ", typeId=" + typeId +
                ", shopId=" + shopId +
                '}';
    }
}