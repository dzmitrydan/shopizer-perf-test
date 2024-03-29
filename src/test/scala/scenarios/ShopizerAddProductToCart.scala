package scenarios

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object ShopizerAddProductToCart {

  def scnAddProductsToCart = {
    scenario("Add Products to Cart")
      .exec(flushHttpCache)
      .exec(flushCookieJar)
      .exitBlockOnFail(
        group("HomePage") {
          exec(api.loadPageContent.ping())
            .exec(api.loadPageContent.contentPages())
            .exec(api.loadPageContent.storeDefault())
            .exec(api.loadPageContent.category())
            .exec(api.productPrice.productPrice())
            .exec(api.productPrice.productPrice("50"))
            .exec(api.productPrice.productPrice("51"))
            .exec(api.productPrice.productPrice("52"))
            .exec(api.productsGroupFeatured.productsGroupFeatured())
            .exec(thinkTimer())
        }
          .group("TablesPage") {
            exec(api.loadPageContent.ping())
              .exec(api.loadPageContent.contentPages())
              .exec(api.loadPageContent.storeDefault())
              .exec(api.loadPageContent.category())
              .exec(api.productPrice.productPrice())
              .exec(api.categoryProduct.categoryProduct("50"))
              .exec(api.categoryProduct.categoryManufacturersProduct("50"))
              .exec(api.categoryProduct.productsStoreCategoryProduct("50"))
              .exec(thinkTimer())
          }
          .group("TableProductCartPage") {
            exec(api.loadPageContent.ping())
              .exec(api.loadPageContent.contentPages())
              .exec(api.loadPageContent.storeDefault())
              .exec(api.loadPageContent.category())
              .exec(api.productPrice.productPrice())
              .exec(api.product.productInfo("1"))
              .exec(api.product.productReviews("1"))
              .exec(thinkTimer())
          }
          .group("AddTableToCart") {
            exec(api.addProductToCart.addTableToCart())
              .exec(api.addProductToCart.getInfoAboutOrder("Table"))
              .exec(thinkTimer())
          }
          .randomSwitch(
            50.0 -> group("ChairsPage") {
              exec(api.loadPageContent.ping())
                .exec(api.loadPageContent.contentPages())
                .exec(api.loadPageContent.storeDefault())
                .exec(api.loadPageContent.category())
                .exec(api.productPrice.productPrice("50"))
                .exec(api.productPrice.productPrice("51"))
                .exec(api.productPrice.productPrice("52"))
                .exec(api.categoryProduct.categoryProduct("51"))
                .exec(api.categoryProduct.productsStoreCategoryProduct("51"))
                .exec(thinkTimer())
            }
              .group("ChairProductCartPage") {
                exec(api.loadPageContent.ping())
                  .exec(api.loadPageContent.contentPages())
                  .exec(api.loadPageContent.storeDefault())
                  .exec(api.loadPageContent.category())
                  .exec(api.productPrice.productPrice("50"))
                  .exec(api.product.productInfo("50"))
                  .exec(api.product.productReviews("50"))
                  .exec(thinkTimer())
                  .exec(thinkTimer())
              }
              .group("AddChairToCart") {
                exec(api.addProductToCart.addChairToCart())
                  .exec(api.addProductToCart.getInfoAboutOrder("Chair"))
                  .exec(thinkTimer())
              }
          )
          .randomSwitch(
            30.0 -> group("CartPage") {
              exec(api.loadPageContent.ping())
                .exec(api.loadPageContent.contentPages())
                .exec(api.loadPageContent.storeDefault())
                .exec(api.loadPageContent.category())
                .exec(api.addProductToCart.getInfoAboutOrderDefault())
                .exec(thinkTimer())
            }
              .group("ProceedToCheckoutPage") {
                exec(api.loadPageContent.ping())
                  .exec(api.loadPageContent.contentPages())
                  .exec(api.loadPageContent.storeDefault())
                  .exec(api.loadPageContent.category())
                  .exec(api.cart.config())
                  .exec(api.cart.cartStore())
                  .exec(api.cart.shipping())
                  .exec(api.cart.zones())
                  .exec(api.cart.cartTotal())
                  .exec(thinkTimer())
              }
          )
      )
  }
}
