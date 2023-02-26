package com.finehome.TestFineHome.dto;

import com.finehome.TestFineHome.dto.response.SuccessResponse;
import com.finehome.TestFineHome.entity.Address;
import com.finehome.TestFineHome.entity.Employee;
import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeResponse extends SuccessResponse {

    private final List<String> imageUrls;
    public int id;
    public String name;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private Address address;

    public EmployeeResponse(Integer id, String name, Address address,
                            List<String> imageList, ZonedDateTime createdAt, ZonedDateTime updatedAt){

        this.id=id;
        this.name=name;

        this.imageUrls = imageList;
        this.address=address;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;

    }

    public static EmployeeResponse build(Employee employee) {

        if (employee.getImages() == null)
            employee.setImages(new HashSet<>(0));
        List<String> imageList = employee.getImages().stream().map(image -> image.getUrlPath().replace("\\", "/")).collect(Collectors.toList());

        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getAddress(),
                imageList,
                employee.getUpdatedAt(),
                employee.getCreatedAt()

        );
    }


    /*   public static SingleProductResponse build(Product product) {
        List<CommentPartialDto> commentPartialDtos = new ArrayList<>();
        for (Comment comment : product.getComments()) {
            commentPartialDtos.add(CommentPartialDto.build(comment, true));
        }
        if (product.getTags() == null)
            product.setTags(new HashSet<>(0));
        List<SingleTagDto> tagNamesList = product.getTags().stream().map(SingleTagDto::build).collect(Collectors.toList());

        if (product.getCategories() == null)
            product.setCategories(new HashSet<>(0));
        List<SingleCategoryDto> categoryList = product.getCategories().stream().map(c -> SingleCategoryDto.build(c, false, false)).collect(Collectors.toList());

        if (product.getImages() == null)
            product.setImages(new HashSet<>(0));
        List<String> imageList = product.getImages().stream().map(image -> image.getUrlPath().replace("\\", "/")).collect(Collectors.toList());

        return new SingleProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getSlug(),
                product.getPrice(),
                commentPartialDtos,
                tagNamesList,
                categoryList,
                imageList
        );
    }
*/

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
