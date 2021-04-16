import React from "react";

class NavbarComponent extends React.Component{
    render() {
        const active_style = "nav-link active"
        const inactive_style = "nav-link"
        return(
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                <div className="container-fluid">
                    <a className="navbar-brand" href="/">My Library</a>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <a className={this.props.active==="home"?active_style:inactive_style} aria-current="page" href="/">Home</a>
                            </li>
                            <li className="nav-item">
                                <a className={this.props.active==="books"?active_style:inactive_style} href="/books">Books</a>
                            </li>
                            <li className="nav-item">
                                <a className={this.props.active==="categories"?active_style:inactive_style} href="/categories">Categories</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        );
    }
}
export default NavbarComponent