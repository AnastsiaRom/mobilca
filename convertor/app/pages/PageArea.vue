<template>
  <Page>
    <ActionBar title="площадь" />
    <StackLayout verticalAlignment="top">
      <convertor :ToDefault="ToDefault" :ToNeed="ToNeed" />
    </StackLayout>
  </Page>
</template>

<script>
import Convertor from "@/components/Convertor.vue";

export default {
  data() {
    return {
      ToDefault: {
        "квадратный метр": function (val) {
          return val;
        },
        "квадратный сантиметр": function (val) {
          return val / 1000;
        },
      },
      ToNeed: {
        "квадратный метр": function (val) {
          return val;
        },
        "квадратный сантиметр": function (val) {
          return val * 1000;
        },
      },
    };
  },
  components: {
    Convertor,
  },
};
</script>
