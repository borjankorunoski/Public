import React from "react";
import NavbarComponent from "../NavbarComponent/NavbarComponent";
import CategoryList from "./CategoryList";

class CategoryComponentMain extends React.Component{
    render() {
        return (
            <div>
                <NavbarComponent active="categories"/>
                <CategoryList/>
            </div>
        );
    }
}
export default CategoryComponentMain